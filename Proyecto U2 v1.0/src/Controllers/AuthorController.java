package Controllers;

import java.util.*;
import Project.*;
import Repositories.*;
import UtilityClasses.StuffCreator;

public class AuthorController {

    static Scanner sc = new Scanner(System.in);

    public static void createAuthor() {
        Author newAuthor = new Author();

        newAuthor.setProfile(StuffCreator.createProfile());
        ProfileRepositories.profiles.add(newAuthor.getProfile());
        AuthorRepositories.authors.add(newAuthor);
    }

    /**Shows all authors*/
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

    /**Modifies a selected attribute of the author object*/
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
                        Date newBD = StuffCreator.createDate();
                        toChange.getProfile().setBirthDate(newBD);
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

    /**Deletes the selected author of the authors ArrayList. Cannot delete someone if they still have books*/
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
