package Project;

import java.util.*;

public class Author {
    private Profile profile;
    public ArrayList<Book> writtenBooks = new ArrayList<>();

    public Profile getProfile()  {
        return profile;
    }

    public void setProfile(String name, String lastName, Date dateOfBirth) {
        profile = new Profile(name, lastName, dateOfBirth);
    }

    public void addWrittenBook(Book newBook) {
        writtenBooks.add(newBook);
    }

    public void deleteBook(Book toDelete) {
        writtenBooks.remove(toDelete);
    }
}
