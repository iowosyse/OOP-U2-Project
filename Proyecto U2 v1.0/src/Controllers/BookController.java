package Controllers;
//Good to go.

import java.util.*;
import Project.*;
import Repositories.*;
import UtilitaryClasses.StuffCreator;

public class BookController {
    static Scanner sc = new Scanner(System.in); //static attributes designed to use them in many methods

    /** Adds a new book to the books ArrayList */
    public static void createBook() {
        String aux;
        int aux2;
        Book newBook = new Book();
        Date bookDate;
        Author theAuthorOfThisBook;
        Date newBookPublishDate = new Date();

        for (int i = 0; i < 1; i++) {
            AuthorController.showAuthors(false);
            System.out.println("Who wrote this book? \n(Enter the index of the author on the list).");
            System.out.println("Enter 0 to go back.");
            System.out.print(">> ");
            aux2 = sc.nextInt();
            sc.nextLine();

            if (aux2 != 0) {
                while (aux2 > AuthorRepositories.authors.size() || aux2 < 0) { //makes sure doesnt goes out of bounds
                    System.out.println("Please enter a valid option");
                    System.out.print(">> ");
                    aux2 = sc.nextInt();
                    sc.nextLine();
                }

                if (aux2 == 0) {
                    System.out.println("Going back...");
                    break;
                }

                theAuthorOfThisBook = AuthorRepositories.authors.get(aux2 - 1);
                newBook.setAuthor(theAuthorOfThisBook);

                Book.idCounter ++; //better and easier, no need to generate random IDs
                newBook.setBookID();
                newBook.publishDate = newBookPublishDate;

                System.out.println("What's the title of the book?");
                System.out.print(">> ");
                aux = sc.nextLine();
                newBook.setTitle(aux);

                System.out.println("When was it published?");
                bookDate = StuffCreator.createDate();
                newBook.setPublishDate(bookDate);

                System.out.println("What's the ISBN?");
                aux = sc.nextLine();
                newBook.setISBN(aux);

                newBook.isAvailable = true;

                BookRepositories.books.add(BookRepositories.addPhantomBook());
                BookRepositories.books.add(newBook);
                BookRepositories.availableBooks.add(newBook);
                theAuthorOfThisBook.addWrittenBook(newBook);

            } else {
                System.out.println("Going back...");
            }
        }
        System.out.println("Book created successfully!");
    }

    /**Gives options on how to show the books to make easier their reading*/
    public static int askHowToShow() { //makes the code easier to read
        int option;

        System.out.println("===============================");
        System.out.println("Show how?");
        System.out.println("1. Show available books");
        System.out.println("2. Show lent books");
        System.out.println("3. Show all books");
        System.out.print(">>");
        option = sc.nextInt();
        sc.nextLine();
        System.out.println("===============================");

        return option;
    }

    public static void showBooks(int option) {
        int count = 1;

        if (option == 1) {
            System.out.println("Showing available books to lend...");
            BookRepositories.showAvailableBooks();

        } else if (option == 2) {
            System.out.println("Showing lent books...");
            BookRepositories.showNotAvailableBooks();

        } else {
            System.out.println("Showing all books...");
            System.out.printf("| %-3s | %-22s | %-20s | %-10s |%n", "No.","Title", "Author", "Date");
            System.out.println("-------------------------------------------------------------------");
            for (Book showingBook : BookRepositories.books) {
                if (!showingBook.getTitle().isEmpty()) {
                    System.out.printf("| %-3s | %-22s | %-20s | %-10s |%n", count, showingBook.getTitle(), showingBook.getAuthor().getProfile().getName()
                            + " " + showingBook.getAuthor().getProfile().getLastName(), (showingBook.publishDate.getMonth() + 1) + "-" + showingBook.publishDate.getYear());
                    System.out.println("-------------------------------------------------------------------");
                    count ++;
                }
            }
        }
    }

    /** Modifies the selected attribute of a book */
    public static void updateBookData() {
        int option, aux;
        String auxStr;
        Author original, auxA;

        for (int i = 0; i < 1; i++) {
            showBooks(1);
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("If you want to update a book that didn't show in the list it is highly possible " +
                    "that the book is in possession of a client");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Which book do you want to update its data? ");
            System.out.println("(Enter 0 to go back.)");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine();

            if (option != 0) {
                while (option > BookRepositories.books.size() || option < 0) {
                    System.out.println("Please enter a valid option");
                    System.out.print(">> ");
                    option = sc.nextInt();
                    sc.nextLine();
                }

                if (option == 0) {
                    System.out.println("Going back...");
                    break;
                }

                Book toChange = BookRepositories.books.get(option - 1);

                System.out.println("===============================");
                System.out.println("What do you want to change?");
                System.out.println("1. Author.");
                System.out.println("2. Title.");
                System.out.println("3. Publish date.");
                System.out.println("4. ISBN.");
                System.out.println("0. Go back.");
                System.out.print(">> ");
                option = sc.nextInt();
                sc.nextLine();
                System.out.println("===============================");

                switch (option) {
                    case 1:
                        AuthorController.showAuthors(false);
                        System.out.println("Who's the new author?");
                        aux = sc.nextInt() - 1;
                        sc.nextLine();

                        if (aux == 0) {
                            System.out.println("Going back...");
                            break;
                        }

                        while (aux > AuthorRepositories.authors.size() || aux < 0){
                            System.out.println("Author not found");
                            System.out.print(">> ");
                            aux = sc.nextInt();
                            sc.nextLine();
                        }

                        original = toChange.getAuthor();
                        auxA = AuthorRepositories.authors.get(aux);

                        changeAuthor(original,auxA,toChange);
                        break;
                    case 2:
                        System.out.println("Enter the new title.");
                        System.out.print(">> ");
                        auxStr = sc.nextLine();

                        toChange.setTitle(auxStr);
                        break;
                    case 3:
                        Date updatedDate = StuffCreator.createDate();

                        toChange.setPublishDate(updatedDate);
                        break;
                    case 4:
                        System.out.println("Enter the new ISBN.");
                        System.out.print(">> ");
                        auxStr = sc.nextLine();

                        toChange.setISBN(auxStr);
                        break;
                    case 0:
                        System.out.println("Going back...");
                        break;
                    default:
                        System.out.println("Not an option.");
                        break;
                }
            } else {
                System.out.println("Going back...");
            }
        }
    }

    public static void deleteBook() {
        int option;
        Author theAuthor;
        Book toDelete;

        do {
            BookRepositories.showAvailableBooks();

            System.out.println("---If you want to delete a book that is not shown the client must return it.---");
            System.out.println("What book do you want to delete?");
            System.out.println("Enter 0 to go back.");
            System.out.print(">> ");
            option = sc.nextInt();

            if (option != 0) {
                while (option > BookRepositories.availableBooks.size() || option < 0) {
                    System.out.println("Please enter a valid option");
                    System.out.print(">> ");
                    option = sc.nextInt();
                    sc.nextLine();
                }

                if (option == 0) {
                    break;
                }

                toDelete = BookRepositories.availableBooks.get(option - 1);

                theAuthor = toDelete.getAuthor();

                theAuthor.writtenBooks.remove(toDelete);
                BookRepositories.books.remove(toDelete);
                BookRepositories.availableBooks.remove(toDelete);
                System.out.println("Book successfully deleted!");
            }
        } while (option != 0);
    }

    public static void changeAuthor(Author oldA, Author newA, Book toChange) {
        toChange.setAuthor(newA);
        newA.addWrittenBook(toChange);
        oldA.deleteBook(toChange);
    }
}

