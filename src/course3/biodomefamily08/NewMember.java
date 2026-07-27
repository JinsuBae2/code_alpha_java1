package course3.biodomefamily08;

import java.time.LocalDateTime;

public class NewMember extends Member{
    public NewMember(String name, LocalDateTime joinDate) {
        super(name, joinDate, "New");
    }
}
