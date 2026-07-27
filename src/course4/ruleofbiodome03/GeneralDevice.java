package course4.ruleofbiodome03;

public class GeneralDevice extends Device{

    public GeneralDevice(String name) {
        super(name);
        System.out.println("일반 기기가 생성되었습니다 : " + getName() + ", " + getBrand());
    }
}
