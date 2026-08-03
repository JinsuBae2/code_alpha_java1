package course4.ruleofbiodome08;

import java.util.Comparator;

public class BorrowSort implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        if (first.getLastBorrowedDate() == null && second.getLastBorrowedDate() == null) {
            return first.getTitle().compareTo(second.getTitle());
        } else if (first.getLastBorrowedDate() == null && second.getLastBorrowedDate() != null) {
            return 1;
        } else if (first.getLastBorrowedDate() != null && second.getLastBorrowedDate() == null) {
            return -1;
        } else if (first.getLastBorrowedDate().compareTo(second.getLastBorrowedDate()) == 0){
            return first.getTitle().compareTo(second.getTitle());
        }
        return first.getLastBorrowedDate().compareTo(second.getLastBorrowedDate());
    }
}
