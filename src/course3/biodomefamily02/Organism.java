package course3.biodomefamily02;

public class Organism {
    // 동식물 정보 필드
    private String name;
    private String species;
    private String habitat;
    private String characteristic;
    private String lifeSpan;

    // 기본 생성자
    public Organism(String name, String species, String habitat) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
    }

    // 특징 및 수명 포함 생성자
    public Organism(String name, String species, String habitat, String characteristic, String lifeSpan) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.characteristic = characteristic;
        this.lifeSpan = lifeSpan;
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

    public String getCharacteristic() {
        return characteristic;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    // 서식지 변경 및 메시지 출력
    public void setHabitat(String habitat) {
        this.habitat = habitat;
        System.out.println("[LifeNest] " + name + "의 서식지가 변경되었습니다.");
    }

    // 특징 변경 및 메시지 출력
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
        System.out.println("[LifeNest] " + name + "의 특징이 변경되었습니다.");
    }

    // 수명 변경 및 메시지 출력
    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
        System.out.println("[LifeNest] " + name + "의 수명이 변경되었습니다.");
    }

    // 동식물 정보 출력
    public void displayInfo() {
        System.out.println("이름 : " + name + ", 종 : " + species + ", 주요 서식지 : " + habitat + ", 특징 : " + characteristic + ", 수명 : " + lifeSpan);
    }
}
