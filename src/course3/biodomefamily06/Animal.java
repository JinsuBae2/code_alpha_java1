package course3.biodomefamily06;

public class Animal {
    private String name;
    private AnimalType type;
    private int age;

    public Animal(String name, AnimalType type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 동물의 이름, 종류, 나이 정보를 출력하는 메서드
    public void printInfo() {
        System.out.println("이름: " + name + ", 종류: " + type.getKoreanName() + ", 나이: " + age + "살");
    }

    @Override
    public String toString() {
        return name + "(" + type.getKoreanName() + ", " + age + "살)";
    }
}
