package course6;

import java.util.*;
import java.util.stream.Collectors;

public class RunBiodome01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 : [신입-하브, 멤버-세이지, 신입-아마라, 운영진-아이샤, 신입-미호, 멤버-하린, 멤버-캐머린, 운영진-리즈키, 신입-라스코, 신입-제레드]
        System.out.print("멤버 리스트를 입력하세요: ");
        String input = sc.nextLine();

        input = input.replace("[", "");
        input = input.replace("]", "");

        String[] members = input.split(",");
        List<String> result = Arrays.stream(members)
                .filter(s -> s.trim().startsWith("신입-"))
                .map(s -> s.trim().replace("신입-", "") + "님 환영합니다")
                .collect(Collectors.toList());

        System.out.println(result);

        Map<String, List<String>> resultBonus = Arrays.stream(members)
                .filter(s -> s.trim().startsWith("신입-") || s.trim().startsWith("멤버-"))
                .collect(Collectors.groupingBy(
                        s -> s.trim().startsWith("신입-") ? "신입 멤버" : "일반 멤버",
                        Collectors.toList()
                ));

        System.out.println("신입 멤버:" + resultBonus.get("신입 멤버"));
        System.out.println("일반 멤버:" + resultBonus.get("일반 멤버"));
    }
}
