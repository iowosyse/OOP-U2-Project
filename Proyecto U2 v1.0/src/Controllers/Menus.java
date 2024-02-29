package Controllers;

import Repositories.TransactionRepositories;

import java.util.*;

public class Menus {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Shows all the options an admin has to manipulate the books
     * */
    public static void bookMenu() {
        int option;

        do {
            System.out.println("===============================");
            System.out.println("1. Create a book.");
            System.out.println("2. Show books.");
            System.out.println("3. Update a book's data.");
            System.out.println("4. Delete a book.");
            System.out.println("0. Go back.");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println("===============================");

            switch (option) {
                case 1:
                    BookController.createBook();
                    break;
                case 2:
                    BookController.showBooks(BookController.askHowToShow());
                    break;
                case 3:
                    BookController.updateBookData();
                    break;
                case 4:
                    BookController.deleteBook();
                    break;
                case 0:
                    System.out.println("Going back...");
                    break;
                default:
                    System.out.println("Not an option.");
                    break;
            }
        } while (option != 0);
    }

    /**Treats the author just as another profile, except this type of profile can be assigned as authors of books*/
    public static void authorMenu() {
        int option;

        do {
            System.out.println("===============================");
            System.out.println("1. Create an author.");
            System.out.println("2. Show authors.");
            System.out.println("3. Update an author's profile.");
            System.out.println("4. Delete an author.");
            System.out.println("0. Go back.");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println("===============================");

            switch (option) {
                case 1:
                    AuthorController.createAuthor();
                    break;
                case 2:
                    AuthorController.showAuthors(true);
                    break;
                case 3:
                    AuthorController.updateAuthorData();
                    break;
                case 4:
                    AuthorController.deleteAuthor();
                    break;
                case 0:
                    System.out.println("Going back...");
                    break;
                default:
                    System.out.println("Not an option.");
                    break;
            }
        } while (option != 0);
    }

    /**General profile manager, CRUDs and stuff*/
    public static void clientMenu() {
        int option;

        do {
            System.out.println("===============================");
            System.out.println("1. Create a client profile.");
            System.out.println("2. Show clients.");
            System.out.println("3. Update a client's data.");
            System.out.println("4. Delete a client.");
            System.out.println("0. Go back.");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println("===============================");

            switch (option) {
                case 1:
                    ClientController.createClient();
                    break;
                case 2:
                    ClientController.showClients(true);
                    break;
                case 3:
                    ClientController.updateClientData();
                    break;
                case 4:
                    ClientController.deleteClient();
                    break;
                case 0:
                    System.out.println("Going back...");
                    break;
                default:
                    System.out.println("Not an option.");
                    break;
            }


        } while (option != 0);
    }

    public static void transactionMenu() {
        int option;

        do {
            System.out.println("===============================");
            System.out.println("1. Create transaction (lend or return book).");
            System.out.println("2. Show transactions.");
            System.out.println("0. Go back.");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println("===============================");

            switch (option) {
                case 1:
                    TransactionController.createTransaction();
                    break;
                case 2:
                    TransactionController.showTransactions();
                    break;
                case 0:
                    System.out.println("Going back...");
                    break;
                default :
                    System.out.println("Not an option.");
                    break;
            }
        } while (option != 0);
    }
}
