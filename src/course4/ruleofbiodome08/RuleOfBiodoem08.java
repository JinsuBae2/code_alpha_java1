package course4.ruleofbiodome08;

import java.time.LocalDate;

public class RuleOfBiodoem08 {
    public static void main(String[] args) {
        // 1. 책 5권 생성
        Book python = new Book("파이썬 마스터", "한송희", LocalDate.of(2020, 1, 1));
        Book java = new Book("자바의 구름", "제임스밥", LocalDate.of(2018, 5, 5));
        Book energy = new Book("에너지 플로우", "키네틱스", LocalDate.of(2019, 8, 15));
        Book mars = new Book("화성에서의 기억", "한송희", LocalDate.of(2021, 3, 3));
        Book vegetable = new Book("야채의 비밀", "송은정", LocalDate.of(2017, 10, 10));

        System.out.println("(도서 객체 생성)");
        System.out.println(python);
        System.out.println(java);
        System.out.println(energy);
        System.out.println(mars);
        System.out.println(vegetable);
        System.out.println();

        // 2. 도서관 시스템 생성 및 책 등록
        System.out.println("(도서관 시스템 생성 및 등록)");
        Library library = new Library();
        library.add(python);
        library.add(java);
        library.add(energy);
        library.add(mars);
        library.add(vegetable);
        System.out.println();

        // 3. 책 대출 및 반납
        System.out.println("(대출1)");
        library.borrow("야채의 비밀");
        System.out.println();

        System.out.println("(대출2)");
        library.borrow("화성에서의 기억");
        System.out.println();

        System.out.println("(반납)");
        library.returnBook("야채의 비밀");
        System.out.println();

        // 4. 기본 제목순 도서 조회
        System.out.println("(도서 조회 결과)");
        library.show();
        System.out.println();

        // 5. 저자 기반 정렬 조회
        System.out.println("(저자 기반 정렬 조회)");
        library.showBy(new AuthorSort());
        System.out.println();

        // 6. 출판일 기반 정렬 조회
        System.out.println("(출판일 기반 정렬 조회)");
        library.showBy(new PublishSort());
        System.out.println();

        // 7. 최근 대출 날짜 기반 정렬 조회
        System.out.println("(최근 대출 날짜 기반 정렬 조회)");
        library.showRecent();
        System.out.println();

        // 8. 보너스: 제목 길이 기반 정렬 조회
        System.out.println("(제목 길이 기반 정렬 조회)");
        library.showBy(new TitleLengthSort());
    }
}
