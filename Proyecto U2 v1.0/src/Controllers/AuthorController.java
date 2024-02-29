package Controllers;

import java.util.*;
import Project.*;
import Repositories.*;

public class AuthorController {

    static Scanner sc = new Scanner(System.in);

    public static void createAuthor() {
        Date dateOfBirth = new Date();
        Author newAuthor = new Author();
        String aux1, aux2;
        int aux3;

        System.out.println("What's the author's name?");
        System.out.print(">> ");
        aux1 = sc.nextLine();

        System.out.println("What's the author's last name?");
        System.out.print(">> ");
        aux2 = sc.nextLine();

        System.out.println("When's their birthday?"); //lego batman 2 goty 2024
        System.out.print("\tDay >> ");
        aux3 = sc.nextInt();
        dateOfBirth.setDate(aux3);
        sc.nextLine();

        System.out.print("\tMonth(numeric) >> ");
        aux3 = sc.nextInt();
        dateOfBirth.setMonth(aux3);
        sc.nextLine();

        System.out.print("\tYear >> ");
        aux3 = sc.nextInt();
        dateOfBirth.setYear(aux3);
        sc.nextLine();

        newAuthor.setProfile(aux1, aux2, dateOfBirth);

        ProfileRepositories.profiles.add(newAuthor.getProfile());
        AuthorRepositories.authors.add(newAuthor);
    }

    public static void showAuthors(boolean showBooks) {
        int count = 1;

        System.out.printf("| %-3s | %-20s | %-6s |%n", "No.", "Author name", "Birth");
        System.out.println("---------------------------------------");

        for (Author thisAuthor : AuthorRepositories.authors) {
            System.out.printf("| %-3s | %-20s | %-6s |%n", count, thisAuthor.getProfile().getName() + " " +
                    thisAuthor.getProfile().getLastName(), (thisAuthor.getProfile().getBirthDate().getMonth() + 1) + "-" +
                    thisAuthor.getProfile().getBirthDate().getYear());

            if (showBooks && !thisAuthor.writtenBooks.isEmpty()) {
                System.out.printf("| %-26s |%n", "Books by " + thisAuthor.getProfile().getName() +
                        " " + thisAuthor.getProfile().getLastName() + ": ");
                for (Book bok : thisAuthor.writtenBooks) {
                    System.out.printf("| %-26s |%n", bok.getTitle());
                }
                System.out.println("---------------------------------------");
            }
            count ++;
        }
    }

    public static void updateAuthorData() {
        int option;
        Author toChange;
        String aux;

        do {
            showAuthors(false);
            System.out.println("Which author do you want to update their data?");
            System.out.println("Enter 0 to go back");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine();

            if (option != 0) {
                while (option > AuthorRepositories.authors.size() || option < 0) {
                    System.out.println("Please enter a valid option");
                    System.out.print(">> ");
                    option = sc.nextInt();
                    sc.nextLine();
                }

                if (option == 0) {
                    break;
                }
                toChange = AuthorRepositories.authors.get(option - 1);

                System.out.println("===============================");
                System.out.println("---If you want to change the books of an author please do it in the 'book menu'.---");
                System.out.println("What do you want to change?");
                System.out.println("1. Name.");
                System.out.println("2. Last name.");
                System.out.println("3. Date of birth.");
                System.out.println("0. Go back.");
                System.out.print(">> ");
                option = sc.nextInt();
                sc.nextLine();
                System.out.println("===============================");

                switch (option) {
                    case 1:
                        System.out.println("Enter the new name.");
                        System.out.print(">> ");
                        aux = sc.nextLine();
                        toChange.getProfile().setName(aux);
                        break;
                    case 2:
                        System.out.println("Enter the new last name.");
                        System.out.print(">> ");
                        aux = sc.nextLine();
                        toChange.getProfile().setLastName(aux);
                        break;
                    case 3:
                        System.out.println("Setting new date...");
                        System.out.println("Enter the new Day.");
                        System.out.print(">> ");
                        option = sc.nextInt();
                        sc.nextLine();
                        toChange.getProfile().getBirthDate().setDate(option);

                        System.out.println("Enter the new Month.");
                        System.out.print(">> ");
                        option = sc.nextInt();
                        sc.nextLine();
                        toChange.getProfile().getBirthDate().setMonth(option);

                        System.out.println("Enter the new Year.");
                        System.out.print(">> ");
                        option = sc.nextInt();
                        sc.nextLine();
                        toChange.getProfile().getBirthDate().setYear(option);
                        break;
                    case 0:
                        System.out.println("Going back...");
                        break;
                    default:
                        System.out.println("Not an option.");
                        break;
                }
            }
        } while (option != 0);
    }

    public static void deleteAuthor() {
        int option;
        Author toDelete1;
        System.out.println("---You must delete every book from an author in order to delete the author themselves---");

        showAuthors(false);

        System.out.println("Which author do you want to delete?");
        System.out.print(">> ");
        option = sc.nextInt();
        sc.nextLine();

        if (option != 0) {
            while (option > AuthorRepositories.authors.size() || option < 0) {
                System.out.println("Please enter a valid option");
                System.out.print(">> ");
                option = sc.nextInt();
                sc.nextLine();
            }

            if (option == 0) {
                System.out.println("Going back...");
            } else {
                toDelete1 = AuthorRepositories.authors.get(option - 1);

                if (!toDelete1.writtenBooks.isEmpty()) {
                    System.out.println("This author cannot be deleted since they still have books.");
                    System.out.println("Remove all of their books in the 'Book menu' with the 'Delete a book' option.");
                } else {
                    AuthorRepositories.authors.remove(toDelete1);
                    System.out.println("Author deleted successfully!");
                }
            }
        }
    }

}
