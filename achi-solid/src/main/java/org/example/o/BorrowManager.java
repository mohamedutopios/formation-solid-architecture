package org.example.o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BorrowManager {
    private Map<Book, String> borrowedBooks = new HashMap<>();

    public void borrowBook(Book book, String member, List<String> books, List<String> members) {
        if (books.contains(book.getTitle()) && members.contains(member)) {
            borrowedBooks.put(book, member);
            System.out.println(member + " has borrowed " + book);
        } else {
            System.out.println("Either book or member does not exist.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books: " + borrowedBooks);
    }
}
