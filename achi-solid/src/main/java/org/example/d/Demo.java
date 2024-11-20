package org.example.d;

import org.example.d.book.*;
import org.example.d.member.MemberManager;
import org.example.d.member.MemberRepository;
import org.example.d.member.Member;
import org.example.d.member.PremiumMember;
import org.example.d.member.RegularMember;

public class Demo {
    public static void main(String[] args) {
        // Initialisation des gestionnaires
        BookRepository bookRepo = new BookManager();
        MemberRepository memberRepo = new MemberManager();
        BorrowManager borrowManager = new BorrowManager(bookRepo, memberRepo);


        Book fictionBook = new FictionBook("The Hobbit");
        Book nonFiction = new NonFictionBook("Sapiens: A Brief History of Humankind");
        Book FictionBook2 = new NonFictionBook("Un jour sans fin");

        // Ajout de livres
        bookRepo.addBook(fictionBook);
        bookRepo.addBook(nonFiction);

        // Ajout de membres
        Member premMember = new PremiumMember("Alice");
        Member regularMember = new RegularMember("John");
        Member regularMember2 = new RegularMember("Tom");

        memberRepo.addMember(premMember);
        memberRepo.addMember(regularMember);
        memberRepo.addMember(regularMember2);

        // Gestion des emprunts
        borrowManager.borrowBook(fictionBook, premMember); // Succès
        borrowManager.borrowBook(nonFiction, regularMember); // Succès
        borrowManager.borrowBook(fictionBook, premMember); // Déjà emprunté
        borrowManager.borrowBook(FictionBook2, regularMember2); // Livre inexistant

        // Affichage des informations
        Displayable[] displayables = {(Displayable) bookRepo, (Displayable) memberRepo, borrowManager };
        for (Displayable displayable : displayables) {
            displayable.display();
            System.out.println(); // Séparation pour la lisibilité
        }
    }
}
