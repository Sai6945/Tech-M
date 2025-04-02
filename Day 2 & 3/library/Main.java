package library;  // ✅ All files are in the same package

import static library.Utility.generateId; // ✅ Static import for generateId()

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Members member1 = new Members("Alice", generateId());  // ✅ Make sure your class is "Members" and not "Member"

        book1.displayBookInfo();  
        member1.displayMemberInfo();
    }
}
