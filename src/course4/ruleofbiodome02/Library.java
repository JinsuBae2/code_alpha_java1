package course4.ruleofbiodome02;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(user.getName())) {
                return;
            }
        }
        users.add(user);
        if (user instanceof Manager) {
            System.out.println("새로운 관리자 '" + user.getName() + "'를 등록합니다.");
        } else {
            System.out.println("새로운 이용자 '" + user.getName() + "'를 등록합니다.");
        }
    }

    public void addBook(User user, Book book){
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(book.getIsbn())) {
                return;
            }
        }
        books.add(book);
        System.out.println("관리자 '" + user.getName() + "'가 책을 추가합니다: '" + book.getTitle() + "', '" + book.getAuthor() + "'");
    }

    public void removeBook(Book book) {
        if (book.isBorrowed()) {
            System.out.println("대출 중인 책은 삭제할 수 없습니다.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(book.getIsbn())) {
                books.remove(i);
                return;
            }
        }
    }

    public void borrowBook(User user, Book book) {
        if (book.isBorrowed()) {
            System.out.println(book.getTitle() + "은 이미 대출 중입니다.");
            return;
        }
        if (book instanceof TextBook && !(user instanceof Student)) {
            System.out.println("교과서는 학생만 대출할 수 있습니다.");
            return;
        }
        user.borrowBook(book);
        System.out.println("이용자 '" + user.getName()  + "' '" + book.getTitle() + "' 대출합니다." );
    }

    public void returnBook(User user, Book book) {
        // 1. 등록되지 않은 책이거나 사용자가 빌리지 않은 책인 경우 -> 예외 메시지 출력
        boolean isRegisterBook = false;
        boolean userIsBorrow = false;
        for (Book value : books) {
            if (value.getIsbn().equals(book.getIsbn())) {
                isRegisterBook = true;
                break;
            }
        }
        for (int i = 0; i < user.getBookList().size(); i++) {
            if (user.getBookList().get(i).getIsbn().equals(book.getIsbn())) {
                userIsBorrow = true;
                break;
            }
        }

        if (isRegisterBook && userIsBorrow) {
            // 2. 반납 성공 시 -> user.returnBook(book); 호출 및 반납 성공 메시지 출력
            user.returnBook(book);
            System.out.println("이용자 '" + user.getName() + "'가 '" + book.getTitle() + "' 반납합니다." );
        } else {
            System.out.println("등록되지 않은 책이거나 대출하지 않은 책입니다.");
        }
    }

    public void searchBooksByAuthor(String author) {
        int bookCount = 0;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                String borrowState = !book.isBorrowed() ? "대출 가능" : "대출 불가";
                System.out.println("제목 : " + book.getTitle() + ", 대출 상태 : " + borrowState);
                bookCount++;
            }
        }
        if (bookCount == 0) {
            System.out.println("검색 결과가 없습니다.");
        }
    }
}
