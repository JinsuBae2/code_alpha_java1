package course4.ruleofbiodome08;

import java.util.Comparator;

public class PublishSort implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        if (first.getPublishedDate().compareTo(second.getPublishedDate()) == 0) {
            return first.getTitle().compareTo(second.getTitle());
        }
        return first.getPublishedDate().compareTo(second.getPublishedDate());
    }
}
