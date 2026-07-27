package course3.biodomefamily09;

public class OrderItem {
    private Menu menu;
    private int quantity;

    public OrderItem(Menu menu) {
        this(menu, 1);
    }

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return menu.getPrice() * quantity;
    }

    @Override
    public String toString() {
        if (menu instanceof Coffee) {
            Coffee coffee = (Coffee) menu;
            return coffee.getName() + " 커피 (사이즈: " + coffee.getSize() + ") - " + quantity + "잔: " + String.format("%,d", getPrice()) + "원";
        } else if (menu instanceof Beverage) {
            Beverage beverage = (Beverage) menu;
            return beverage.getName() + " (사이즈: " + beverage.getSize() + ") - " + quantity + "잔: " + String.format("%,d", getPrice()) + "원";
        } else if (menu instanceof Sandwich) {
            return menu.getName() + " - " + quantity + "개: " + String.format("%,d", getPrice()) + "원";
        }
        return menu.getName() + " - " + quantity + "개: " + String.format("%,d", getPrice()) + "원";
    }
}
