package org.example.i;


import org.example.i.book.Book;
import org.example.i.book.BookManager;
import org.example.i.book.NonFictionBook;
import org.example.i.member.Member;
import org.example.i.member.MemberManager;
import org.example.i.member.PremiumMember;
import org.example.i.member.RegularMember;
import org.example.i.BorrowManager;


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

        Displayable[] displayables = { bookManager, memberManager, borrowManager };
        for (Displayable displayable : displayables) {
            displayable.display();
        }
    }
}
