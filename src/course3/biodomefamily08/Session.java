package course3.biodomefamily08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private LocalDateTime date;
    private String location;
    private List<Member> attendees = new ArrayList<>();
    private Member creator;
    private String status = "개설";

    public Session(LocalDateTime date, String location, Member creator) {
        this.date = date;
        this.location = location;
        this.creator = creator;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Member> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Member> attendees) {
        this.attendees = attendees;
    }

    public Member getCreator() {
        return creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addAttendee(Member member) {
        attendees.add(member);
    }

    @Override
    public String toString() {
        List<String> nameList = attendees.stream().map(Member::getName).toList();
        return date.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일")) + ", " + location + ", " + nameList + ", " + creator.getName() + ", " + status;
    }
}
