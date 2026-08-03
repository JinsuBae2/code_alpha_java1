package course4.ruleofbiodome08;

import java.util.Comparator;

public class AuthorSort implements Comparator<Book> {


    @Override
    public int compare(Book first, Book second) {
        if (first.getAuthor().compareTo(second.getAuthor()) == 0) {
            return first.getTitle().compareTo(second.getTitle());
        }
        return first.getAuthor().compareTo(second.getAuthor());
    }
}
