package hcl.library.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import hcl.library.exception.BorrowerLimitExceededException;
import hcl.library.exception.ItemNotAvailableException;
import hcl.library.exception.ItemNotFoundException;
import hcl.library.exception.LibraryException;
import hcl.library.model.LibraryItem;
import hcl.library.model.Member;
import hcl.library.repository.InMemoryRepository;
import hcl.library.repository.Repository;

public class LibraryService {
    private static final int BORROW_LIMIT = 5;

    private final Repository<LibraryItem, Integer> items =
            new InMemoryRepository<>(LibraryItem::getId);
    private final Repository<Member, Integer> members =
            new InMemoryRepository<>(Member::getId);
    private final Map<Integer, Queue<Integer>> waitlists = new HashMap<>();

    public void addItem(LibraryItem item) {
        items.save(item);
    }

    public void registerMember(Member member) {
        if (members.findById(member.getId()).isPresent()) {
            throw new LibraryException("Member id already exists: " + member.getId());
        }
        members.save(member);
    }

    public void borrowItem(int memberId, int itemId) {
        Member member = getMember(memberId);
        LibraryItem item = getItem(itemId);
        if (member.getBorrowedItems().size() >= BORROW_LIMIT) {
            throw new BorrowerLimitExceededException(BORROW_LIMIT);
        }
        if (!item.isAvailable()) {
            throw new ItemNotAvailableException(itemId);
        }

        item.borrow();
        member.borrowItem(item);
    }

    public double returnItem(int memberId, int itemId, int daysLate) {
        Member member = getMember(memberId);
        LibraryItem item = getItem(itemId);
        if (!member.getBorrowedItems().contains(item)) {
            throw new LibraryException("Member does not have item " + itemId);
        }

        double fee = item.lateFee(daysLate);
        member.returnItem(item);
        item.giveBack();
        issueToNextWaitingMember(item);
        return fee;
    }

    public void addToWaitlist(int memberId, int itemId) {
        Member member = getMember(memberId);
        LibraryItem item = getItem(itemId);
        if (item.isAvailable()) {
            throw new LibraryException("Item is available; borrow it instead");
        }
        if (member.getBorrowedItems().contains(item)) {
            throw new LibraryException("Member already has this item");
        }

        Queue<Integer> queue = waitlists.computeIfAbsent(itemId, id -> new ArrayDeque<>());
        if (queue.contains(memberId)) {
            throw new LibraryException("Member is already on this waitlist");
        }
        queue.add(memberId);
    }

    public List<LibraryItem> getAllItems() {
        return items.findAll();
    }

    public List<Member> getAllMembers() {
        return members.findAll();
    }

    public List<Integer> getWaitlist(int itemId) {
        getItem(itemId);
        Queue<Integer> queue = waitlists.get(itemId);
        return queue == null ? new ArrayList<>() : new ArrayList<>(queue);
    }

    public LibraryItem getItem(int itemId) {
        return items.findById(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    public Member getMember(int memberId) {
        return members.findById(memberId)
                .orElseThrow(() -> new LibraryException("Member not found: " + memberId));
    }

    private void issueToNextWaitingMember(LibraryItem item) {
        Queue<Integer> queue = waitlists.get(item.getId());
        while (queue != null && !queue.isEmpty()) {
            int memberId = queue.remove();
            Member nextMember = members.findById(memberId).orElse(null);
            if (nextMember != null && nextMember.getBorrowedItems().size() < BORROW_LIMIT) {
                item.borrow();
                nextMember.borrowItem(item);
                break;
            }
        }
        if (queue != null && queue.isEmpty()) {
            waitlists.remove(item.getId());
        }
    }
}