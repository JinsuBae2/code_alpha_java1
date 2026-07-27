package course3.biodomefamily09;

import java.util.ArrayDeque;
import java.util.Queue;

public class OrderList {
    private Queue<Order> orders = new ArrayDeque<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getNextOrder() {
        return orders.poll();
    }

    public Queue<Order> getOrders() {
        return orders;
    }

    public boolean cancelOrder(String customerName, String productName) {
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName) && "주문 완료".equals(order.getStatus())) {
                for (OrderItem item : order.getItems()) {
                    if (item.getMenu().getName().equals(productName)) {
                        order.setStatus("취소");
                        System.out.println(customerName + "님의 " + productName + " 주문이 취소되었습니다.");
                        return true;
                    }
                }
            }
        }
        System.out.println("취소할 수 있는 주문을 찾을 수 없습니다.");
        return false;
    }
}
