package course3.biodomefamily08;

import java.time.LocalDateTime;

public interface PracticeAdministrator {
    void cancelSession(Session session);
    void postponeSession(Session session, LocalDateTime newDate);
}
