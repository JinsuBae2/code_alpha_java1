package course3.biodomefamily01;

public class Organism {
    // 동식물 정보 필드 (이름, 종, 서식지)
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

    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // 동식물 정보 출력
    public void displayInfo() {
        System.out.println("이름: " + name + " 종: " + species + " 서식지: " + habitat);
    }
}
