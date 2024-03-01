package Controllers;

import Project.*;
import Repositories.*;
import java.util.*;
import UtilitaryClasses.*;

public class ClientController {
    static Scanner sc = new Scanner(System.in);

    public static void createClient() {
        Client newClient = new Client();


        newClient.setProfile(StuffCreator.createProfile());

        ProfileRepositories.profiles.add(newClient.getProfile());
        ClientRepositories.clients.add(newClient);
    }

    public static void showClients(boolean showBooks) {
        int count = 1;

        System.out.printf("| %-3s | %-20s | %-6s |%n", "No.", "Client name", "Birth");
        System.out.println("---------------------------------------");

        for (Client thisClient : ClientRepositories.clients) {
            System.out.printf("| %-3s | %-20s | %-6s |%n", count, thisClient.getProfile().getName() + " " +
                    thisClient.getProfile().getLastName(), (thisClient.getProfile().getBirthDate().getMonth() + 1) + "-" +
                    thisClient.getProfile().getBirthDate().getYear());

            if (thisClient.hasBooks() && showBooks) {
                System.out.printf("| %-26s |%n", "Books borrowed by " + thisClient.getProfile().getName() +
                        " " + thisClient.getProfile().getLastName() + ":");
                for (Book bok : thisClient.getBorrowedBooks()) {
                    if (!bok.getTitle().isEmpty()) {
                        System.out.printf("| %-26s |%n", bok.getTitle());
                    }
                }
            }
            System.out.println("---------------------------------------");
            count ++;
        }
    }

    public static void updateClientData(){
        int option;
        Client toChange;
        String aux;

        do {
            showClients(false);
            System.out.println("Which client do you want to update their data?");
            System.out.println("Enter 0 to go back");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine();

            if (option != 0) {
                while (option > ClientRepositories.clients.size() || option < 0) {
                    System.out.println("Please enter a valid option");
                    System.out.print(">>");
                    option = sc.nextInt();
                    sc.nextLine();
                }

                if (option == 0) {
                    break;
                }

                toChange = ClientRepositories.clients.get(option - 1);

                if (option != 0) {
                    System.out.println("===============================");
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
                } else {
                    System.out.println("Going back...");
                }
            }
        } while (option != 0);
    }

    public static void deleteClient() {
        int option;
        Client toDelete1;
        System.out.println("---The client must return all og their books in order to delete themselves---");

        do {
            showClients(false);

            System.out.println("Which client do you want to delete?");
            System.out.println("Enter 0 to go back.");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine();

            if (option != 0) {
                while (option > ClientRepositories.clients.size() || option < 0) {
                    System.out.println("Please enter a valid option");
                    System.out.print(">> ");
                    option = sc.nextInt();
                    sc.nextLine();
                }

                if (option == 0) {
                    break;
                }

                toDelete1 = ClientRepositories.clients.get(option - 1);

                if (!toDelete1.getBorrowedBooks().isEmpty()) {
                    System.out.println("This client cannot be deleted since they have not returned all of their books.");
                    System.out.println("Return all of the books in the 'Transaction menu'.");
                } else {
                    ClientRepositories.clients.remove(toDelete1);
                    System.out.println("Client deleted successfully!");
                }
            }
        } while (option != 0);
    }
}
