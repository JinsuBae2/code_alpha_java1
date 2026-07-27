package course3.biodomefamily09;

public class Coffee extends Menu {
    private String beanType;
    private String size;

    public Coffee(String name, int price, String beanType, String size) {
        super(name, price);
        this.beanType = beanType;
        this.size = size;
    }

    public String getBeanType() {
        return beanType;
    }

    public void setBeanType(String beanType) {
        this.beanType = beanType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
