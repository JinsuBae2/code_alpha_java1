package course4.ruleofbiodome03;

public abstract class Device {
    private String name;
    private static final String BRAND = "DOMETech";
    private boolean isOn;
    private boolean isEnergySaving;

    public Device(String name) {
        this.name = name;
        isOn = false;
        isEnergySaving = false;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return BRAND;
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isEnergySaving() {
        return isEnergySaving;
    }

    public void setEnergySaving(boolean energySaving) {
        isEnergySaving = energySaving;
    }

    public void powerOn() {
        this.isOn = true;
        System.out.println(name + " 전원을 켰습니다.");
    }

    public void powerOff() {
        this.isOn = false;
        System.out.println(name + " 전원을 껐습니다.");
    }



}
