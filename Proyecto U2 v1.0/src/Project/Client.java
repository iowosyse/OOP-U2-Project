package Project;

import java.util.*;

public class Client {
    public static Random ran = new Random();
    private Profile profile;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Client() {

    }

    public Client (String name, String lastName, Date BD) {
        setProfile(name, lastName, BD);
    }

    public int getNumberOfBorrowedBooks() { //this because of phantom books
        int n = 0;

        for (Book bok : borrowedBooks) {
            if (!bok.getTitle().isEmpty()) {
                n ++;
            }
        }

        return n;
    }

    public boolean hasBooks(){
        return !borrowedBooks.isEmpty(); //gracias profe
    }

    public void showBorrowedBooks() {
        int count = 1;
        for (Book showingBook : borrowedBooks) {
            if (!showingBook.getTitle().isEmpty()) {
                System.out.printf("| %-3s | %-22s | %-20s | %-10s |%n", count, showingBook.getTitle(), showingBook.getAuthor().getProfile().getName()
                        + " " + showingBook.getAuthor().getProfile().getLastName(), (showingBook.publishDate.getMonth() + 1) + "-" + showingBook.publishDate.getYear());
                System.out.println("-------------------------------------------------------------------");
                count++;
            }
        }
    }

    public void setProfile(String name, String lastName, Date dateOfBirth) {
        profile = new Profile(name, lastName, dateOfBirth);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }


    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
