package course3.biodomefamily03;

public class Animal extends Organism {
    // 동물 고유 필드 (소화 방식, 먹이)
    private String digestionType;
    private String food;

    // 생성자 (부모 필드 super로 초기화)
    public Animal(String name, String species, String habitat, String digestionType, String food) {
        super(name, species, habitat);
        this.digestionType = digestionType;
        this.food = food;
    }

    // Getter & Setter
    public String getDigestionType() {
        return digestionType;
    }

    public void setDigestionType(String digestionType) {
        this.digestionType = digestionType;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    // 동물 정보 출력 오버라이딩
    @Override
    public void displayInfo() {
        System.out.println(getName() + ", " + getSpecies() + ", " + getHabitat() + ", " + digestionType + ", " + food);
    }
}
