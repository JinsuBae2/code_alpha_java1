package course3.biodomefamily08;

import java.time.LocalDateTime;
import java.util.List;

public class BiodomeFamily08 {
    public static void main(String[] args) {
        Club club = new Club();
        LocalDateTime baseDate = LocalDateTime.of(2130, 9, 12, 18, 0);

        // 1. 새로운 멤버 생성 및 가입 출력
        Staff john = new Staff("John", baseDate);
        RegularMember jane = new RegularMember("Jane", baseDate);
        RegularMember doe = new RegularMember("Doe", baseDate);
        NewMember amy = new NewMember("Amy", baseDate);
        NewMember leo = new NewMember("Leo", baseDate);

        club.registerMembers(List.of(john), "운영진");
        club.registerMembers(List.of(jane, doe), "일반 멤버");
        club.registerMembers(List.of(amy, leo), "신규 멤버");
        System.out.println();

        // 2. 운영진 John이 연습 세션을 개설 및 클럽 등록
        Session session = john.createSession(baseDate, "도메 스타디움", john);
        club.addSession(session);
        System.out.println();

        // 3. 일반 멤버 Jane과 신규 멤버 Amy가 연습에 참가
        System.out.println(jane.getName() + "과 " + amy.getName() + "가 연습 세션에 참가합니다.");
        session.addAttendee(jane);
        session.addAttendee(amy);
        System.out.println();

        // 4. 개설 상태인 연습을 검색 및 정보 출력
        List<Session> openedSessions = club.searchByStatus("개설");
        for (Session s : openedSessions) {
            System.out.println(s);
        }
        System.out.println();

        // 5. 연습 날짜를 일주일 뒤로 연기
        LocalDateTime postponedDate = baseDate.plusWeeks(1);
        john.postponeSession(session, postponedDate);
        System.out.println();

        // 6. 운영진 John이 개설된 연습을 취소
        john.cancelSession(session);
        System.out.println();

        // [추가 테스트 1] 날짜 조건으로 세션 검색 테스트 (연기된 9월 19일 날짜로 검색)
        System.out.println("--- [추가 테스트 1] 2130년 9월 19일 날짜의 연습 세션 검색 ---");
        List<Session> dateSessions = club.searchByDate(postponedDate);
        for (Session s : dateSessions) {
            System.out.println("검색된 세션: " + s);
        }
        System.out.println();

        // [추가 테스트 2] 진행 상태 조건으로 세션 검색 테스트 ("취소" 상태 검색)
        System.out.println("--- [추가 테스트 2] '취소' 상태의 연습 세션 검색 ---");
        List<Session> cancelledSessions = club.searchByStatus("취소");
        for (Session s : cancelledSessions) {
            System.out.println("검색된 세션: " + s);
        }
        System.out.println();

        // [추가 테스트 3] 권한 검증 테스트 (일반 멤버 Jane의 취소 권한 검증)
        System.out.println("--- [추가 테스트 3] 일반 멤버(Jane)의 세션 취소 권한 검증 ---");
        if (jane instanceof PracticeAdministrator) {
            System.out.println(jane.getName() + "은(는) 세션 관리 권한이 있습니다.");
        } else {
            System.out.println("[권한 안내] " + jane.getName() + "은(는) 연습 세션을 취소/연기할 관리 권한이 없습니다.");
        }
        System.out.println();

        // [추가 테스트 4] 생성자 오버로딩 테스트 (스킬 수준을 포함한 가입)
        System.out.println("--- [추가 테스트 4] 생성자 오버로딩 검증 (스킬 수준 지정 가입) ---");
        Member testMember = new Member("Alex", baseDate, "Expert");
        System.out.println("오버로딩 생성자로 가입된 회원 정보: " + testMember);
    }
}
