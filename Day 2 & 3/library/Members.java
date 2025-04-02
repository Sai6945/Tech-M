package library;  // ✅ Same package

public class Members {
    private String name;
    private int memberId;

    public Members(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public void displayMemberInfo() {
        System.out.println("Member Name: " + name + ", Member ID: " + memberId);
    }
}
