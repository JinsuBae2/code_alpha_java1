package course4.ruleofbiodome08;

import java.util.Comparator;

public class TitleLengthSort implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        int length = first.getTitle().length() - second.getTitle().length();
        if (length == 0) {
            return first.getTitle().compareTo(second.getTitle());
        }
        return length;
    }
}
