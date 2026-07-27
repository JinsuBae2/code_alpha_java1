package course3.biodomefamily08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface PracticeCreator {
    default Session createSession(LocalDateTime date, String location, Member creator) {
        Session session = new Session(date, location, creator);
        String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"));
        System.out.println(creator.getName() + "이 " + formattedDate + ", " + location + "에 연습 세션을 오픈했습니다.");
        return session;
    }
}
