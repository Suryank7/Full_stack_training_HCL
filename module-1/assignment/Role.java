package assignment;

public enum Role {
    MANAGER(12),
    ADMIN(10),
    ENGINEER(12),
    ACCOUNTANT(8);

    private final int bonusPercentage;

    Role(int bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    public int getBonusPercentage() {
        return bonusPercentage;
    }
}
