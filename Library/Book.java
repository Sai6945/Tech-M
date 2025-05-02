import java.util.*;

//class Book
public class Book {

//instance variables
private int sNo;
private String bookName;
private String authorName;

//parameterized constructor
Book(int sN, String bookN,String authorN){
    //assigning values to instance variables
    this.sNo = sN;
    this.bookName = bookN;
    this.authorName = authorN;
}
//book b1 = new book(-,- ,-)

//Default constructor
Book(){

}

//getter method to return value of instance variable sNo
public int getsNo(){
    return sNo;
}

//getter method to return value of instance variable bookName
public String getBookName(){
    return bookName;
}

//getter method to return value of instance variable authorName
public String getAuthorName(){
    return authorName;
}

//setter method to assign value to instance variable sNo
public void setsNo(int sNo){
    this.sNo = sNo;
}

//setter method to assign value to instance variable bookName
public void setBookName(String bookName){
    this.bookName = bookName;
}

//setter method to assign value to instance variable authorName
public void setAuthorName(String authorName){
    this.authorName = authorName;
}

//creating an object of Scanner class to take input from user
Scanner sc = new Scanner(System.in);

//method to display book menu
public void bookMenu() {
    System.out.println("1: Enter Serial Number of a Book.");
    //taking integer input from user and assigning it to instance variable sNo
    this.sNo = sc.nextInt();
    System.out.println("2: Enter Book Name: ");
    //taking string input from user and assigning it to instance variable bookName
    this.bookName = sc.next();
    System.out.println("3: Enter Author Name: ");
    //taking string input from user and assigning it to instance variable authorName
    this.authorName = sc.next();
}

//method to display update options
public void userUpdateDisplay(){
    System.out.println("1: To change the Serial Number of Book.");
    System.out.println("2: To change the Book Name.");
    System.out.println("3: To change the Author Name.");
}

//override toString method to print Book information
@Override
public String toString(){
    return " Serial Number: " + sNo + "\r\n" + " Book Title: " + bookName + "\r\n" + " Author Name: "+ authorName;
}
}