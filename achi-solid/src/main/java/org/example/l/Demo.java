package org.example.l;

import org.example.l.book.BookManager;
import org.example.l.book.Book;
import org.example.l.book.NonFictionBook;


public class Demo {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        MemberManager memberManager = new MemberManager();
        BorrowManager borrowManager = new BorrowManager();
        Book bookFiction = new NonFictionBook("The Hobbit");
        Book bookNonFiction = new NonFictionBook("Les Misérables");

        bookManager.addBook(bookFiction);
        bookManager.addBook(bookNonFiction);

        Member premMember = new PremiumMember("Alice");
        Member regularMember = new RegularMember("John");

        memberManager.addMember(premMember);
        memberManager.addMember(regularMember);

        borrowManager.borrowBook(bookFiction, premMember,
                bookManager.getBooks().stream().map(Book::getTitle).toList(),
                memberManager.getMembers().stream().map(Member::getName).toList());

        borrowManager.borrowBook(bookNonFiction, regularMember,
                bookManager.getBooks().stream().map(Book::getTitle).toList(),
                memberManager.getMembers().stream().map(Member::getName).toList());

        bookManager.displayBooks();
        memberManager.displayMembers();
        borrowManager.displayBorrowedBooks();
    }
}
