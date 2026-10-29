package hcl.library.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import hcl.library.model.LibraryItem;
import hcl.library.model.Member;

public final class ReportUtil {
    private ReportUtil() {
    }

    public static String buildReport(List<LibraryItem> items, List<Member> members) {
        StringBuilder report = new StringBuilder("Library Items\n");
        for (LibraryItem item : items) {
            report.append(item)
                    .append(" | late fee (3 days): ")
                    .append(item.lateFee(3))
                    .append(System.lineSeparator());
        }

        report.append(System.lineSeparator()).append("Members\n");
        for (Member member : members) {
            report.append(member).append(System.lineSeparator());
        }
        return report.toString();
    }

    public static void export(String fileName, List<LibraryItem> items, List<Member> members)
            throws IOException {
        Files.write(Paths.get(fileName), buildReport(items, members).getBytes(StandardCharsets.UTF_8));
    }
}