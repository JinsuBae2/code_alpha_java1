package course6.runbiodome02;

import java.util.Scanner;
import java.util.function.Predicate;

public class RunBiodome02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EnergyDistributor distributor = new EnergyDistributor();

        Predicate<Integer> lowEnergyCheck = energy -> energy <= 1000;

        System.out.println("바이오도메 에너지 관리 시스템에 오신 것을 환영합니다.\n");

        while (true) {
            System.out.println("1. 전체 에너지 조회하기");
            System.out.println("2. 특정 구역 에너지 할당하기");
            System.out.println("3. 구역별 에너지 조회하기");
            System.out.println("4. 종료하기");
            System.out.print("\n메뉴를 선택하세요: ");

            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    distributor.printEnergy();
                    break;
                case 2:
                    System.out.print("할당하려는 구역 이름을 입력하세요: ");
                    String zone = sc.next();
                    System.out.print("할당하려는 에너지량을 입력하세요: ");
                    int amount = sc.nextInt();

                    distributor.allocateEnergy(zone, amount);

                    if (lowEnergyCheck.test(distributor.getTotalEnergy())) {
                        System.out.println("⚠️ [경고] 남은 전체 에너지가 1000 이하입니다!");
                    }
                    break;
                case 3:
                    distributor.zoneEnergy();
                    break;
                case 4:
                    System.out.println("\n→ 바이오도메 에너지 관리 시스템을 종료합니다. 감사합니다.");
                    return;
                default:
                    System.out.println("→ 1번에서 4번 메뉴를 선택해주세요.");
                    break;
            }
            
        }
    }
}
