package course3.biodomefamily03;

public class Plant extends Organism {
    // 식물 고유 필드 (개화 시기, 열매 유무)
    private String bloomSeason;
    private String fruitStatus;

    // 생성자 (부모 필드 super로 초기화)
    public Plant(String name, String species, String habitat, String bloomSeason, String fruitStatus) {
        super(name, species, habitat);
        this.bloomSeason = bloomSeason;
        this.fruitStatus = fruitStatus;
    }

    // Getter & Setter
    public String getBloomSeason() {
        return bloomSeason;
    }

    public void setBloomSeason(String bloomSeason) {
        this.bloomSeason = bloomSeason;
    }

    public String getFruitStatus() {
        return fruitStatus;
    }

    public void setFruitStatus(String fruitStatus) {
        this.fruitStatus = fruitStatus;
    }

    // 식물 정보 출력 오버라이딩
    @Override
    public void displayInfo() {
        System.out.println(getName() + ", " + getSpecies() + ", " + getHabitat() + ", " + bloomSeason + ", " + fruitStatus);
    }
}
