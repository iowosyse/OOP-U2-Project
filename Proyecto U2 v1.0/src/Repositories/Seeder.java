package Repositories;

import Project.*;
import Repositories.AuthorRepositories;
import Repositories.BookRepositories;
import Repositories.ClientRepositories;
import Repositories.TransactionRepositories;

import java.util.Date;


/**When running the program this will pop up and start some classes and attributes*/
public class Seeder {
    public static void initialize(){
        Author jeffKinney = new Author();
        Date jkDate = new Date();
        Date doawk = new Date();
        Date doawk2 = new Date();
        jkDate.setDate(19);
        jkDate.setMonth(1);
        jkDate.setYear(1971);
        jeffKinney.setProfile("Jeff", "Kinney", jkDate);

        doawk.setDate(1);
        doawk.setMonth(2);
        doawk.setYear(2010);
        Book diaryOfAWimpyKid1 = new Book("978-607-400-334-5", "Diary of a Wimpy Kid", true, doawk,
                "B|1", jeffKinney);

        jeffKinney.addWrittenBook(diaryOfAWimpyKid1);

        doawk2.setDate(1);
        doawk2.setMonth(0);
        doawk2.setYear(2013);
        Book diaryOfAWimpyKid2 = new Book("978-607-400-335-2", "Diary of a Wimpy Kid 2", true,
                doawk2, "B|2", jeffKinney);
        jeffKinney.addWrittenBook(diaryOfAWimpyKid2);

        Author orsonScottCard = new Author();
        Date oscDate = new Date();
        oscDate.setDate(24);
        oscDate.setMonth(7);
        oscDate.setYear(1951);
        orsonScottCard.setProfile("Orson Scott", "Card", oscDate);

        Date eg = new Date();
        eg.setDate(15);
        eg.setDate(0);
        eg.setYear(1985);
        Book endersGame = new Book("978-607-316-667-6", "Ender's Game", true, eg,
                "B|3", orsonScottCard);
        orsonScottCard.addWrittenBook(endersGame);

        Author stephenKing = new Author();
        Date skDate = new Date();
        skDate.setDate(21);
        skDate.setMonth(8);
        skDate.setYear(1947);
        stephenKing.setProfile("Stephen", "King", skDate);

        Date itd = new Date();
        itd.setDate(15);
        itd.setMonth(8);
        itd.setYear(1986);
        Book it = new Book("978-607-310-552-1", "IT", true, itd, "B|4", stephenKing);
        stephenKing.writtenBooks.add(it);

        BookRepositories.books.add(diaryOfAWimpyKid1);
        BookRepositories.books.add(diaryOfAWimpyKid2);
        BookRepositories.books.add(endersGame);
        BookRepositories.books.add(it);

        AuthorRepositories.authors.add(jeffKinney);
        AuthorRepositories.authors.add(orsonScottCard);
        AuthorRepositories.authors.add(stephenKing);

        Date candeBD = new Date();
        candeBD.setDate(11);
        candeBD.setMonth(7);
        candeBD.setYear(2005);

        Date first = new Date();
        first.setDate(20);
        first.setMonth(6);
        first.setYear(2023);

        Client cande = new Client("Cande", "Ortega", candeBD);
        ClientRepositories.clients.add(cande);

        Transaction firstTransaction = new Transaction("T|0000", "Borrow", first, cande,
                endersGame);
        cande.getBorrowedBooks().add(endersGame);
        endersGame.isAvailable = false;
        firstTransaction.setTransactingClient(cande);
        TransactionRepositories.transactions.add(firstTransaction);

        BookRepositories.setAvailableBooks();
        BookRepositories.setNotAvailableBooks();

        //Main.easterEggCounter ++; //if you get this one wth you doin here?? -4
    }
}
