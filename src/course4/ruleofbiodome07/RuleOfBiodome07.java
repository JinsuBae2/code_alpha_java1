package course4.ruleofbiodome07;

import java.time.LocalDateTime;

public class RuleOfBiodome07 {
    public static void main(String[] args) {
        // 1. 마지막 물 공급 일자, 물 공급 주기, 적정 습도가 서로 다른 식물 5개 생성
        Plant lily = new Plant("백합", "화초", 100,
                LocalDateTime.of(2130, 3, 12, 12, 0), 15, 50);
        Plant raspberry = new Plant("나무딸기", "과일나무", 200,
                LocalDateTime.of(2130, 3, 12, 14, 20), 20, 35);
        Plant cactus = new Plant("선인장", "다육식물", 5,
                LocalDateTime.of(2130, 3, 12, 9, 0), 30, 25);
        Plant lilac = new Plant("라일락", "화초", 20,
                LocalDateTime.of(2130, 3, 12, 11, 0), 25, 45);
        Plant bamboo = new Plant("대나무", "대나무", 15,
                LocalDateTime.of(2130, 3, 11, 19, 0), 50, 55);

        // 2. 생성한 식물 정보 출력
        System.out.println("(식물 객체 생성)");
        System.out.println(lily);
        System.out.println(raspberry);
        System.out.println(cactus);
        System.out.println(lilac);
        System.out.println(bamboo);
        System.out.println();

        // 3. 오늘의 습도를 포함한 식물 관리 시스템 생성 및 관리 대상 식물 등록
        System.out.println("(식물 관리 시스템 생성 및 등록)");
        PlantManagementSystem system = new PlantManagementSystem(40);
        system.addPlant(lily);
        system.addPlant(raspberry);
        system.addPlant(cactus);
        system.addPlant(lilac);
        system.addPlant(bamboo);

        // 4. 우선순위가 가장 높은 식물을 확인하고 물을 공급하는 작업을 3번 반복
        for (int i = 1; i <= 3; i++) {
            System.out.println();
            System.out.println("(우선 순위에 따른 식물 출력 및 관리" + i + ")");
            Plant next = system.showNextPlant();

            if (next != null) {
                system.waterPlant(next);
            }
        }

        // 5. 세 번 관리한 뒤 남아 있는 식물을 우선순위 순으로 출력
        System.out.println();
        system.showRemainingPlants();
    }
}
