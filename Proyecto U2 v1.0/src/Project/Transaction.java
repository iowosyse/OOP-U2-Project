package Project;

import java.util.*;

public class Transaction {

    static Random ran = new Random();
    private String tID = "";
    public String typeOfTransaction;
    private Date dateOfTransaction;
    private Client transactingClient;
    private Book transactedBook;

    public  Transaction() {

    }

    public Transaction(String tID, String typeOfTransaction, Date dateOfTransaction, Client transactingClient, Book transactedBook) {
        this.tID = tID;
        this.typeOfTransaction = typeOfTransaction;
        this.dateOfTransaction = dateOfTransaction;
        this.transactingClient = transactingClient;
        this.setTransactedBook(transactedBook);
    }

    public void setTID() {
        int number = ran.nextInt(999) + 1;
        String base = "T|";

        tID += base + number;
    }

    public String gettID() {
        return tID;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public Client getTransactingClient() {
        return transactingClient;
    }

    public void setTransactingClient(Client transactingClient) {
        this.transactingClient = transactingClient;
    }

    public Book getTransactedBook() {
        return transactedBook;
    }

    public void setTransactedBook(Book transactedBook) {
        this.transactedBook = transactedBook;
    }
}
