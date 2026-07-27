package course3.biodomefamily08;

import java.time.LocalDateTime;

public class Member {
    private String name;
    private LocalDateTime joinDate;
    private String skillLevel;

    public Member(String name, LocalDateTime joinDate) {
        this(name, joinDate, "일반");
    }

    public Member(String name, LocalDateTime joinDate, String skillLevel) {
        this.name = name;
        this.joinDate = joinDate;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return getName() + "(" + getSkillLevel() + ")";
    }
}
