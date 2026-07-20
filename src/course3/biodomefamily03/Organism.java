package course3.biodomefamily03;

public class Organism {
    // 공통 동식물 필드 (이름, 종, 서식지)
    private String name;
    private String species;
    private String habitat;

    // 생성자
    public Organism(String name, String species, String habitat) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // 정보 출력 (자식 클래스에서 오버라이딩)
    public void displayInfo() {
        System.out.print(name + ", " + species + ", " + habitat);
    }
}
