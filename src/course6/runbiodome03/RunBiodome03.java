package course6.runbiodome03;

import java.util.Scanner;

public class RunBiodome03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FruitStore store = new FruitStore();

        // 1. 파일 데이터 로드
        store.loadData();

        System.out.println("과일 상점에 오신 것을 환영합니다!\n");

        while (true) {
            System.out.println("\n1. 과일 판매하기");
            System.out.println("2. 과일 재고 추가하기");
            System.out.println("3. 모든 과일 재고 조회하기");
            System.out.println("4. 최근 판매 기록 조회하기");
            System.out.println("5. 종료하기");
            System.out.print("메뉴를 선택하세요: ");

            if (!sc.hasNextInt()) {
                System.out.println("숫자를 입력해 주세요.");
                sc.next();
                continue;
            }

            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("판매할 과일의 이름을 입력하세요: ");
                    String sellName = sc.next();
                    System.out.print("판매할 수량을 입력하세요: ");
                    int sellQty = sc.nextInt();
                    store.sellFruit(sellName, sellQty);
                    break;
                case 2:
                    System.out.print("재고를 추가할 과일의 이름을 입력하세요: ");
                    String addName = sc.next();
                    System.out.print("추가할 수량을 입력하세요: ");
                    int addQty = sc.nextInt();
                    store.addStock(addName, addQty);
                    break;
                case 3:
                    store.printAllStock();
                    break;
                case 4:
                    System.out.print("조회할 과일의 이름을 입력하세요: ");
                    String historyName = sc.next();
                    store.printRecentHistory(historyName);
                    break;
                case 5:
                    store.saveData();
                    return;
                default:
                    System.out.println("1번에서 5번 사이의 메뉴를 선택해주세요.");
                    break;
            }
        }
    }
}
