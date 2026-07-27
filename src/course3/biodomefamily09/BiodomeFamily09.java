package course3.biodomefamily09;

import java.time.LocalDateTime;

public class BiodomeFamily09 {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        // 1. 커피 메뉴 3가지 추가
        Coffee blend = new Coffee("블렌드", 4000, "블렌드", "톨");
        Coffee dark = new Coffee("다크", 4500, "다크", "톨");
        Coffee decaf = new Coffee("디카페인", 4200, "디카페인", "톨");
        cafe.addMenu(blend);
        cafe.addMenu(dark);
        cafe.addMenu(decaf);

        // 2. 음료 메뉴 3가지 추가
        Beverage chamomile = new Beverage("캐모마일", 3000, "톨");
        Beverage orangeJuice = new Beverage("오렌지 쥬스", 3500, "톨");
        Beverage water = new Beverage("물", 1000, "톨");
        cafe.addMenu(chamomile);
        cafe.addMenu(orangeJuice);
        cafe.addMenu(water);

        // 3. 샌드위치 메뉴 3가지 추가
        Sandwich vegSandwich = new Sandwich("야채 샌드위치", 5000, "야채", LocalDateTime.of(2123, 10, 10, 0, 0));
        Sandwich hamSandwich = new Sandwich("햄 샌드위치", 6000, "햄", LocalDateTime.of(2123, 10, 11, 0, 0));
        // 치즈 샌드위치는 만료날짜가 지난 상태로 등록
        Sandwich cheeseSandwich = new Sandwich("치즈 샌드위치", 5500, "치즈", LocalDateTime.of(2122, 1, 6, 0, 0));
        cafe.addMenu(vegSandwich);
        cafe.addMenu(hamSandwich);
        cafe.addMenu(cheeseSandwich);
        System.out.println();

        // 4. 제이미: 커피 2잔, 만료되지 않은 샌드위치 1개 주문
        LocalDateTime time1 = LocalDateTime.of(2123, 10, 7, 14, 5, 32);
        Order order1 = new Order("제이미", time1);
        order1.addItem(new OrderItem(blend, 2));
        order1.addItem(new OrderItem(vegSandwich, 1));
        cafe.placeOrder(order1);

        // 5. 레냐: 음료 1개 주문 (1개 주문 시 수량 생략 생성자 호출)
        LocalDateTime time2 = LocalDateTime.of(2123, 10, 7, 14, 6, 15);
        Order order2 = new Order("레냐", time2);
        order2.addItem(new OrderItem(chamomile));
        cafe.placeOrder(order2);

        // 6. 만료날짜가 지난 치즈 샌드위치 주문 시도
        LocalDateTime time3 = LocalDateTime.of(2123, 10, 7, 14, 7, 0);
        Order order3 = new Order("대니", time3);
        order3.addItem(new OrderItem(cheeseSandwich, 1));
        cafe.placeOrder(order3);

        // 7. 모든 주문 출력 (FIFO 순서)
        cafe.printAllOrders();
    }
}
