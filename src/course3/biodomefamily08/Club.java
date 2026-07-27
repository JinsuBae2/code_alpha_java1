package course3.biodomefamily08;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private List<Member> members = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public List<Session> getSessions() {
        return sessions;
    }


    public List<Session> searchByStatus(String status) {
        List<Session> statusSessions = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getStatus().equals(status)) {
                statusSessions.add(session);
            }
        }
        return statusSessions;
    }

    public List<Session> searchByDate(LocalDateTime date) {
        List<Session> dateSessions = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getDate().toLocalDate().equals(date.toLocalDate())) {
                dateSessions.add(session);
            }
        }
        return dateSessions;
    }

    public void registerMembers(List<Member> newMembers, String role) {
        if (newMembers == null || newMembers.isEmpty()) return;

        List<String> names = new ArrayList<>();
        for (Member m : newMembers) {
            this.addMember(m);
            names.add(m.getName());
        }

        String joinedNames = String.join(", ", names);
        System.out.println(joinedNames + "이(가) " + role + "(으)로 가입되었습니다.");
    }
}
