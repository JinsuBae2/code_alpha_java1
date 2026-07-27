package course3.biodomefamily08;

import java.time.LocalDateTime;

public class RegularMember extends Member implements PracticeCreator {
    public RegularMember(String name, LocalDateTime joinDate) {
        super(name, joinDate, "일반");
    }
}
