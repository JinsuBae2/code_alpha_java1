package course3.biodomefamily08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Staff extends Member implements PracticeCreator, PracticeAdministrator {

    public Staff(String name, LocalDateTime joinDate) {
        super(name, joinDate, "운영진");
    }

    public Staff(String name, LocalDateTime joinDate, String skillLevel) {
        super(name, joinDate, skillLevel);
    }

    @Override
    public void cancelSession(Session session) {
        session.setStatus("취소");
        String formattedDate = session.getDate().format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"));
        System.out.println(formattedDate + ", " + session.getLocation() + " 연습 세션이 취소되었습니다.");
    }

    @Override
    public void postponeSession(Session session, LocalDateTime newDate) {
        session.setDate(newDate);
        String formattedDate = newDate.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"));
        System.out.println(this.getName() + "이 " + formattedDate + ", " + session.getLocation() + "에 연습 세션을 연기했습니다.");
    }
}
