package org.example.o;

public class Demo {
    public static void main(String[] args) {

        BookManager bookManager = new BookManager();
        MemberManager memberManager = new MemberManager();
        BorrowManager borrowManager = new BorrowManager();

        Book bookFiction = new FictionBook("The Hobbit");
        Book bookNonFiction = new NonFictionBook("Les Misérables");
        bookManager.addBook(bookFiction);
        bookManager.addBook(bookNonFiction);

        memberManager.addMember("Alice");
        borrowManager.borrowBook(bookFiction, "Alice",
                bookManager.getBooks().stream().map(Book::getTitle).toList(),
                memberManager.getMembers());

        bookManager.displayBooks();
        memberManager.displayMembers();
        borrowManager.displayBorrowedBooks();
    }
}
