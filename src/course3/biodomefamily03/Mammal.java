package course3.biodomefamily03;

public class Mammal extends Animal {
    // 포유류 고유 필드 (온혈 여부)
    private boolean warmBlooded;

    // 생성자 (Animal 상속)
    public Mammal(String name, String species, String habitat, String digestionType, String food, boolean warmBlooded) {
        super(name, species, habitat, digestionType, food);
        this.warmBlooded = warmBlooded;
    }

    // Getter
    public boolean isWarmBlooded() {
        return warmBlooded;
    }

    // 포유류 고유 메서드 (새끼를 낳음)
    public void giveBirth() {
        System.out.println(getName() + "이(가) 새끼를 낳았습니다. (온혈동물 여부: " + warmBlooded + ")");
    }
}
