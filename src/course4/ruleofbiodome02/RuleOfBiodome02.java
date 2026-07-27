package course4.ruleofbiodome02;

public class RuleOfBiodome02 {
    public static void main(String[] args) {
        Library library = new Library();

        // 1. 관리자 1명, 이용자 2명 생성 및 도서관 등록
        Manager seiko = new Manager(1, "세이코");
        Member merry = new Member(2, "메리");
        Member manok = new Member(3, "만옥");

        library.addUser(seiko);
        library.addUser(merry);
        library.addUser(manok);
        System.out.println();

        // 2. 도서 생성
        Book book1 = new Book("자바의 구름", "book1", "제임스밥");
        Book book2 = new Book("파이썬 마스터", "book2", "한송희");
        Book book3 = new Book("에너지 플로우", "book3", "키네틱스");
        Book book4 = new Book("화성에서의 기억", "book4", "한송희");
        Book book5 = new Book("야채의 비밀", "book5", "송은정");
        Book book6 = new Book("자료구조의 언덕", "book6", "황수");
        Book book7 = new Book("그곳에 가면", "book7", "한송희");

        // 3. 관리자 '세이코'가 책 5권 도서관에 등록
        library.addBook(seiko, book1);
        library.addBook(seiko, book2);
        library.addBook(seiko, book3);
        library.addBook(seiko, book4);
        library.addBook(seiko, book5);
        System.out.println();

        // 4. 이용자 '메리'가 '자바의 구름' 대출
        library.borrowBook(merry, book1);
        System.out.println();

        // 5. 관리자가 책 2권 추가
        library.addBook(seiko, book6);
        library.addBook(seiko, book7);
        System.out.println();

        // 6. 이미 대출한 책('자바의 구름')을 다른 이용자('만옥')가 대출 시도
        library.borrowBook(manok, book1);
        System.out.println();

        // 7. 이용자 '메리'가 빌린 책 반납
        library.returnBook(merry, book1);
        System.out.println();

        // 8. 관리자 '세이코'가 '화성에서의 기억' 대출
        library.borrowBook(seiko, book4);
        System.out.println();

        // 9. 저자명('한송희')으로 책 검색 및 대출 상태 출력
        library.searchBooksByAuthor("한송희");
        System.out.println();

        // === [예외 상황 처리 테스트] ===
        System.out.println("=== [예외 상황 처리 테스트] ===");

        // 예외 1: 등록되지 않은 책 반납 시도
        System.out.println("--- 예외 1: 등록되지 않은 책 반납 시도 ---");
        Book unregisteredBook = new Book("미등록 도서", "unreg01", "미상");
        library.returnBook(merry, unregisteredBook);
        System.out.println();

        // 예외 2: 검색 결과가 없는 저자 검색 시도
        System.out.println("--- 예외 2: 검색 결과가 없는 저자 검색 시도 ---");
        library.searchBooksByAuthor("홍길동");
        System.out.println();

        // 예외 3: 대출 중인 책 삭제 시도 (book4는 현재 '세이코'가 대출 중)
        System.out.println("--- 예외 3: 대출 중인 책 삭제 시도 ---");
        library.removeBook(book4);
        System.out.println();

        // 10. [보너스 과제 테스트] 학생 회원 등록, 교과서 및 잡지 등록 후 권한 시뮬레이션
        System.out.println("=== [보너스 과제 테스트] ===");
        Student student = new Student(4, "철수");
        library.addUser(student);

        TextBook textbook = new TextBook("수학의 정석", "tb01", "홍성대");
        Magazine magazine = new Magazine("월간 과학", "mg01", "동아일보");

        library.addBook(seiko, textbook);
        library.addBook(seiko, magazine);
        System.out.println();

        // 10-1. 일반 회원 '메리'가 교과서 대출 시도 -> 대출 거부
        System.out.println("--- 일반 이용자 '메리'가 교과서 대출 시도 ---");
        library.borrowBook(merry, textbook);
        System.out.println();

        // 10-2. 학생 회원 '철수'가 교과서 대출 시도 -> 대출 성공
        System.out.println("--- 학생 이용자 '철수'가 교과서 대출 시도 ---");
        library.borrowBook(student, textbook);
    }
}
