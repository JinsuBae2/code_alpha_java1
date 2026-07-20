package course3.biodomefamily03;

public class Fish extends Animal {
    // 어류 고유 필드 (지느러미 개수)
    private int finsCount;

    // 생성자 (Animal 상속)
    public Fish(String name, String species, String habitat, String digestionType, String food, int finsCount) {
        super(name, species, habitat, digestionType, food);
        this.finsCount = finsCount;
    }

    // Getter
    public int getFinsCount() {
        return finsCount;
    }

    // 어류 고유 메서드 (수영)
    public void swim() {
        System.out.println(getName() + "이(가) " + finsCount + "개의 지느러미로 헤엄칩니다.");
    }
}
