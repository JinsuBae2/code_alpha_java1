package course6.runbiodome04;

import java.util.Scanner;

public class RunBiodome04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FruitStore store = new FruitStore();
        store.loadData();

        System.out.println("과일 상점에 오신 것을 환영합니다!\n");

        while (true) {
            System.out.println("\n1. 모든 과일 재고 조회하기");
            System.out.println("2. 가장 많이 팔린 과일 조회하기");
            System.out.println("3. 총 판매 과일 수 조회하기");
            System.out.println("4. 과일별 평균 판매 개수 조회하기");
            System.out.println("5. 과일별 판매 조회");
            System.out.println("6. 종료하기");
            System.out.print("메뉴를 선택하세요: ");

            if (!sc.hasNextInt()) {
                System.out.println("존재하지 않는 메뉴입니다. 1번에서 6번을 선택해주세요.");
                sc.next();
                continue;
            }

            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    store.printAllStock();
                    break;
                case 2:
                    store.printMostSoldFruit();
                    break;
                case 3:
                    store.printTotalSalesCount();
                    break;
                case 4:
                    store.printAverageSalesPerFruit();
                    break;
                case 5:
                    System.out.print("조회할 과일의 이름을 입력하세요: ");
                    String fruitName = sc.next();
                    store.printFruitSalesDetail(fruitName);
                    break;
                case 6:
                    System.out.println("\n과일 상점 관리 시스템을 종료합니다! 감사합니다.");
                    return;
                default:
                    System.out.println("존재하지 않는 메뉴입니다. 1번에서 6번을 선택해주세요.");
                    break;
            }
        }
    }
}
