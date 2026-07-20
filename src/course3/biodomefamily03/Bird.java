package course3.biodomefamily03;

public class Bird extends Animal {
    // 조류 고유 필드 (날개폭)
    private double wingSpan;

    // 생성자 (Animal 상속)
    public Bird(String name, String species, String habitat, String digestionType, String food, double wingSpan) {
        super(name, species, habitat, digestionType, food);
        this.wingSpan = wingSpan;
    }

    // Getter
    public double getWingSpan() {
        return wingSpan;
    }

    // 조류 고유 메서드 (비행)
    public void fly() {
        System.out.println(getName() + "이(가) 날개폭 " + wingSpan + "m로 하늘을 날아갑니다.");
    }
}
