package course4.ruleofbiodome03;

public class SmartDevice extends Device{
    private String feature;

    public SmartDevice(String name, String feature) {
        super(name);
        this.feature = feature;
        System.out.println("스마트 기기가 생성되었습니다 : " + getName() + ", " + getBrand() + ", " + feature);
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void activateFeature() {
        System.out.println(getName() + " 고급 기능을 활성화 시켰습니다.");
    }

}
