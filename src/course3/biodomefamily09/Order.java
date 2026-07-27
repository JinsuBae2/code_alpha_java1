package course3.biodomefamily09;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private LocalDateTime orderTime;
    private List<OrderItem> items = new ArrayList<>();
    private String status = "주문 완료"; // 주문 완료, 제조 중, 완료, 취소

    public Order(String customerName, LocalDateTime orderTime) {
        this.customerName = customerName;
        this.orderTime = orderTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalPrice() {
        int total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("고객: ").append(customerName).append("\n");
        sb.append("주문 시각: ").append(orderTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");
        for (OrderItem item : items) {
            sb.append(item.toString()).append("\n\n");
        }
        sb.append("총 금액: ").append(String.format("%,d", getTotalPrice())).append("원");
        return sb.toString();
    }
}
