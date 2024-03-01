package Controllers;

import Project.*;
import Repositories.*;
import java.util.*;

public class TransactionController {
    static Scanner sc = new Scanner(System.in);

    public static void showTransactions() {
        int option, aux, i = 0;
        Date botLimit = new Date(), topLimit = new Date();

        System.out.println("===============================");
        System.out.println("How do you want to show the transactions?");
        System.out.println("1. By date range");
        System.out.println("2. By client");
        System.out.println("3. By book");
        System.out.println("4. All transactions");
        System.out.print(">> ");
        option = sc.nextInt();
        sc.nextLine();
        System.out.println("===============================");

        switch (option) {
            case 1:
                setDates(botLimit, topLimit);
                System.out.printf("-----------------------------------------------------------------------------------------------%n");
                System.out.printf("| %-9s | %-6s | %-10s | %-20s | %-9s | %-22s |%n", "ID", "Type", "Date", "Client name", "BookID", "Title");
                System.out.printf("-----------------------------------------------------------------------------------------------%n");
                for (Transaction toShow : TransactionRepositories.transactions){
                    if (toShow.getDateOfTransaction().before(topLimit) && toShow.getDateOfTransaction().after(botLimit)) {
                        System.out.printf("| %-9s | %-6s | %-10s | %-20s | %-9s | %-22s |%n", toShow.gettID(),
                                toShow.typeOfTransaction, toShow.getDateOfTransaction().getDate() + "-" +
                                        (toShow.getDateOfTransaction().getMonth() + 1) + "-" + toShow.getDateOfTransaction().getYear(),
                                toShow.getTransactingClient().getProfile().getName() +
                                        " " + toShow.getTransactingClient().getProfile().getLastName(),
                                toShow.getTransactedBook().getBookID(), toShow.getTransactedBook().getTitle());
                        System.out.printf("-----------------------------------------------------------------------------------------------%n");
                    }
                }
                break;
            case 2:
                ClientController.showClients(false);
                System.out.println("Of whom do you want to see their transactions?");
                System.out.print(">> ");
                aux = sc.nextInt();
                sc.nextLine();

                Client theClient = ClientRepositories.clients.get(aux - 1);

                System.out.printf("-----------------------------------------------------------------------------------------------%n");
                System.out.printf("| %-9s | %-6s | %-10s | %-20s | %-9s | %-22s |%n", "ID", "Type", "Date", "Client name", "BookID", "Title");
                System.out.printf("-----------------------------------------------------------------------------------------------%n");
                for (Transaction toShow : TransactionRepositories.transactions){
                    if (toShow.getTransactingClient() == theClient) {
                        System.out.printf("| %-9s | %-6s | %-10s | %-20s | %-9s | %-22s |%n", toShow.gettID(),
                                toShow.typeOfTransaction, toShow.getDateOfTransaction().getDate() + "-" +
                                        (toShow.getDateOfTransaction().getMonth() + 1) + "-" + toShow.getDateOfTransaction().getYear(),
                                toShow.getTransactingClient().getProfile().getName() +
                                        " " + toShow.getTransactingClient().getProfile().getLastName(),
                                toShow.getTransactedBook().getBookID(), toShow.getTransactedBook().getTitle());
                        System.out.printf("-----------------------------------------------------------------------------------------------%n");
                    }
                }
                break;
            case 3:
                BookController.showBooks(3);
                System.out.println("Of which book do you want to show its transactions?");
                aux = sc.nextInt();
                sc.nextLine();

                Book theBook = BookRepositories.books.get(aux - 1);

                System.out.printf("-----------------------------------------------------------------------------------------------%n");
                System.out.printf("| %-9s | %-6s | %-10s | %-20s | %-9s | %-22s |%n", "ID", "Type", "Date", "Client name", "BookID", "Title");
                System.out.printf("-----------------------------------------------------------------------------------------------%n");
                for (Transaction toShow : TransactionRepositories.transactions){
                    if (toShow.getTransactedBook() == theBook) {
                        System.out.printf("| %-9s | %-6s | %-10s | %-20s | %-9s | %-22s |%n", toShow.gettID(),
                                toShow.typeOfTransaction, toShow.getDateOfTransaction().getDate() + "-" +
                                        (toShow.getDateOfTransaction().getMonth() + 1) + "-" + toShow.getDateOfTransaction().getYear(),
                                toShow.getTransactingClient().getProfile().getName() +
                                        " " + toShow.getTransactingClient().getProfile().getLastName(),
                                toShow.getTransactedBook().getBookID(), toShow.getTransactedBook().getTitle());
                        System.out.printf("-----------------------------------------------------------------------------------------------%n");
                    }
                }
                break;
            case 4:
                System.out.printf("-----------------------------------------------------------------------------------------------%n");
                System.out.printf("| %-9s | %-6s | %-10s | %-20s | %-9s | %-22s |%n", "ID", "Type", "Date", "Client name", "BookID", "Title");
                System.out.printf("-----------------------------------------------------------------------------------------------%n");

                for (Transaction toShow : TransactionRepositories.transactions) {
                    System.out.printf("| %-9s | %-6s | %-10s | %-20s | %-9s | %-22s |%n", toShow.gettID(),
                            toShow.typeOfTransaction, toShow.getDateOfTransaction().getDate() + "-" +
                                    (toShow.getDateOfTransaction().getMonth() + 1) + "-" + toShow.getDateOfTransaction().getYear(),
                            toShow.getTransactingClient().getProfile().getName() +
                                    " " + toShow.getTransactingClient().getProfile().getLastName(),
                            toShow.getTransactedBook().getBookID(), toShow.getTransactedBook().getTitle());
                    System.out.printf("-----------------------------------------------------------------------------------------------%n");
                }
                break;
            default:
                System.out.println("Not an option");
                break;
        }
    }

    public static void setDates(Date botLimit, Date topLimit) {
        int aux;

        System.out.println("Since when do you want to show the transactions?");
        System.out.print("\tDay >> ");
        aux = sc.nextInt();
        botLimit.setDate(aux);
        sc.nextLine();

        System.out.print("\tMonth(numeric) >> ");
        aux = sc.nextInt();
        botLimit.setMonth(aux);
        sc.nextLine();

        System.out.print("\tYear >> ");
        aux = sc.nextInt();
        botLimit.setYear(aux);
        sc.nextLine();

        botLimit.setHours(12);
        botLimit.setMinutes(00);
        botLimit.setSeconds(00);

        System.out.println("Until when do you want to show the transactions?");
        System.out.print("\tDay >> ");
        aux = sc.nextInt();
        topLimit.setDate(aux);
        sc.nextLine();

        System.out.print("\tMonth(numeric) >> ");
        aux = sc.nextInt();
        topLimit.setMonth(aux);
        sc.nextLine();

        System.out.print("\tYear >> ");
        aux = sc.nextInt();
        topLimit.setYear(aux);
        sc.nextLine();

        topLimit.setHours(12);
        topLimit.setMinutes(00);
        topLimit.setSeconds(00);

    }

    public static void createTransaction() {
        int option, aux;
        Transaction newTransaction = new Transaction();
        Client transactingClient;
        Date dateOfTransaction = new Date();

        System.out.println("==============================="); //ñ
        System.out.println("1. Lend a book.");
        System.out.println("2. Return a book.");
        System.out.println("0. Go back.");
        System.out.print(">> ");
        option = sc.nextInt();
        sc.nextLine();
        System.out.println("===============================");

        if (option == 1) {
            Book toLend;

            newTransaction.setTID();
            setTransactionDate(dateOfTransaction);

            BookRepositories.showAvailableBooks();
            System.out.println("Which book do you want to lend?");
            System.out.print(">> ");
            aux = sc.nextInt();
            sc.nextLine();

            toLend = BookRepositories.availableBooks.get(aux - 1);

            ClientController.showClients(false);
            System.out.println("To whom do you want to lend it?");
            System.out.print(">> ");
            aux = sc.nextInt();
            sc.nextLine();
            transactingClient = ClientRepositories.clients.get(aux - 1);

            if (aux - 1 > BookRepositories.availableBooks.size()) {
                System.out.println("That book does not exists.");
            } else {
                if (transactingClient.getNumberOfBorrowedBooks() == 3) {
                    System.out.println("---This client must return a book before borrowing another one.---");
                } else {
                    transactingClient.getBorrowedBooks().add(toLend);

                    newTransaction.setTransactingClient(transactingClient);
                    newTransaction.setDateOfTransaction(dateOfTransaction);
                    newTransaction.setTransactedBook(toLend);
                    newTransaction.typeOfTransaction = "Borrow";
                    toLend.isAvailable = false;

                    BookRepositories.notAvailableBooks.add(toLend);
                    BookRepositories.availableBooks.remove(toLend);
                    transactingClient.getBorrowedBooks().add(BookRepositories.addPhantomBook());
                    TransactionRepositories.transactions.add(newTransaction);
                }
            }

        } else if (option == 2) {
            Book toReturn;

            newTransaction.setTID();
            setTransactionDate(dateOfTransaction);
            newTransaction.typeOfTransaction = "Return";

            ClientController.showClients(true);
            System.out.println("Who wants to return a book?");
            System.out.print(">> ");
            aux = sc.nextInt();
            sc.nextLine();
            transactingClient = ClientRepositories.clients.get(aux - 1);

            if (transactingClient.getBorrowedBooks().isEmpty()) {
                System.out.println("This client has no books");
            } else {
                Book template;
                int trueIndex = 0;

                transactingClient.showBorrowedBooks();
                System.out.println("What books do they want to return?");
                System.out.print(">> ");
                aux = sc.nextInt();
                sc.nextLine();

                template = transactingClient.getBorrowedBooks().get(aux - 1);

                for (int i = aux; template.getTitle().isEmpty() && trueIndex != aux; i ++) {
                    template = transactingClient.getBorrowedBooks().get(i - 1);
                    if (!template.getTitle().isEmpty()) {
                        trueIndex ++;
                    }
                } /*Since we need to create blank books, the right index will be hard to be found
                so this loop serves as the 'searcher' for the actual index */

                toReturn = template;
                toReturn.isAvailable = true;

                transactingClient.getBorrowedBooks().remove(toReturn);
                newTransaction.setDateOfTransaction(dateOfTransaction);
                newTransaction.setTransactingClient(transactingClient);
                newTransaction.setTransactedBook(toReturn);

                BookRepositories.availableBooks.add(toReturn);
                BookRepositories.notAvailableBooks.remove(toReturn);
                TransactionRepositories.transactions.add(newTransaction);
            }

        } else if (option == 0) {
            System.out.println("Going back...");
        } else {
            System.out.println("Not an option");
        }
        System.out.println("===============================");
    }

    public static void setTransactionDate(Date dateOfTransaction) { //somehow the all mighty stuff creator does not work here ;-;
        int aux;

        System.out.println("What's the date of the transaction?");
        System.out.print("\tDay >> ");
        aux = sc.nextInt();
        dateOfTransaction.setDate(aux);
        sc.nextLine();

        System.out.print("\tMonth(numeric) >> ");
        aux = sc.nextInt();
        dateOfTransaction.setMonth(aux);
        sc.nextLine();

        System.out.print("\tYear >> ");
        aux = sc.nextInt();
        dateOfTransaction.setYear(aux);
        sc.nextLine();

        dateOfTransaction.setHours(12);
        dateOfTransaction.setMinutes(01);
        dateOfTransaction.setSeconds(01);
    }
}
