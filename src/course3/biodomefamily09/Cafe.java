package course3.biodomefamily09;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Menu> menuList = new ArrayList<>();
    private OrderList orderList = new OrderList();

    public void addMenu(Menu menu) {
        menuList.add(menu);
        if (menu instanceof Coffee) {
            System.out.println("커피가 추가되었습니다. " + menu);
        } else if (menu instanceof Beverage) {
            System.out.println("음료가 추가되었습니다. " + menu);
        } else if (menu instanceof Sandwich) {
            System.out.println("샌드위치가 추가되었습니다. " + menu);
        }
    }

    public void removeMenu(Menu menu) {
        menuList.remove(menu);
    }

    public Menu getMenu(String name) {
        for (Menu menu : menuList) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        return null;
    }

    public void placeOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            if (item.getMenu() instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) item.getMenu();
                if (sandwich.isExpired(order.getOrderTime())) {
                    System.out.println("--");
                    System.out.println();
                    System.out.println(sandwich.getName() + " 주문 시도...");
                    System.out.println("오류: 주문할 수 없는 상품입니다. (만료날짜: " + sandwich.getExpirationDate().toLocalDate() + ")");
                    System.out.println();
                    System.out.println("--");
                    System.out.println();
                    System.out.println();
                    return;
                }
            }
        }
        orderList.addOrder(order);
        System.out.println("=== 주문이 추가되었습니다. ===");
        System.out.println(order);
        System.out.println();
    }

    public void printAllOrders() {
        int count = 1;
        for (Order order : orderList.getOrders()) {
            System.out.println("주문" + count + ".");
            System.out.println(order);
            System.out.println();
            count++;
        }
    }

    public OrderList getOrderList() {
        return orderList;
    }
}
