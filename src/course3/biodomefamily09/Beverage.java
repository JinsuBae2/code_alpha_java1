package course3.biodomefamily09;

public class Beverage extends Menu {
    private String size;

    public Beverage(String name, int price, String size) {
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
