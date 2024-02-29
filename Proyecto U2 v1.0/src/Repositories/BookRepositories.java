package Repositories;

import Project.Author;
import Project.Book;
import java.util.ArrayList;
import java.util.Date;

public class BookRepositories {
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<Book> availableBooks = new ArrayList<>();
    public static ArrayList<Book> notAvailableBooks = new ArrayList<>();

    /**We need adding phantom books because when borrowing one, it may replace prior books, this ending in
     * having the same book borrowed twice or thrice and not being able to return the original books.
     * Phantom books make space between actual books, so they don't eat each other*/
    public static Book addPhantomBook() {
        Book phantomBook;
        Date phantomDate = new Date();
        Author phantomAuthor = new Author();

        phantomDate.setDate(0);
        phantomDate.setMonth(0);
        phantomDate.setYear(0);

        phantomBook = new Book("", "", true, phantomDate, "", phantomAuthor);


        return phantomBook;
    }

    public static void setAvailableBooks (){
        for (Book available : books) {
            if (available.isAvailable) {
                availableBooks.add(available);
            }
        }
    }

    public static void setNotAvailableBooks() {
        for (Book notAvailable : books) {
            if (!notAvailable.isAvailable) {
                notAvailableBooks.add(notAvailable);
            }
        }
    }

    public static void showNotAvailableBooks() {
        int count = 1;

        System.out.printf("| %-3s | %-22s | %-20s | %-10s |%n", "No.","Title", "Author", "Date");
        System.out.println("-------------------------------------------------------------------");
        for (Book showingBook : notAvailableBooks) {
            if (!showingBook.isAvailable && !showingBook.getTitle().isEmpty()) {
                System.out.printf("| %-3s | %-22s | %-20s | %-10s |%n", count, showingBook.getTitle(), showingBook.getAuthor().getProfile().getName()
                        + " " + showingBook.getAuthor().getProfile().getLastName(), (showingBook.publishDate.getMonth() + 1) + "-" + showingBook.publishDate.getYear());
                System.out.println("-------------------------------------------------------------------");
                count ++;
            }
        }
    }

    public static void showAvailableBooks() {
        int count = 1;

        System.out.printf("| %-3s | %-22s | %-20s | %-10s |%n", "No.","Title", "Author", "Date");
        System.out.println("-------------------------------------------------------------------");
        for (Book showingBook : availableBooks) {
            if (showingBook.isAvailable && !showingBook.getTitle().isEmpty()) {
                System.out.printf("| %-3s | %-22s | %-20s | %-10s |%n", count, showingBook.getTitle(), showingBook.getAuthor().getProfile().getName()
                        + " " + showingBook.getAuthor().getProfile().getLastName(), (showingBook.publishDate.getMonth() + 1) + "-" + showingBook.publishDate.getYear());
                System.out.println("-------------------------------------------------------------------");
                count ++;
            }
        }
    }
}
