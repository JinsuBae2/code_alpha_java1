package course3.biodomefamily06;

import java.util.ArrayList;
import java.util.List;

public class BiodomeFamily06 {
    public static void main(String[] args) {
        // 1. 초기 5마리 동물 객체 생성 (ArrayList 사용)
        List<Animal> initialAnimals = new ArrayList<>();
        initialAnimals.add(new Animal("제니", AnimalType.MONKEY, 4));
        initialAnimals.add(new Animal("고먀", AnimalType.ELEPHANT, 4));
        initialAnimals.add(new Animal("타이", AnimalType.TIGER, 9));
        initialAnimals.add(new Animal("로아", AnimalType.RHINO, 5));
        initialAnimals.add(new Animal("바비", AnimalType.DEER, 7));

        System.out.println("원래 이동 순서:");
        System.out.println(initialAnimals);
        System.out.println();

        // 2. MigrationManager를 이용해 안전한 이동 순서 배치
        MigrationManager manager = new MigrationManager(initialAnimals);
        try {
            List<Animal> safeSequence = manager.getSafeSequence();
            System.out.println("배치된 안전한 이동 순서:");
            System.out.println(safeSequence);
        } catch (UnsafeSequenceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        // 3. 보너스 과제: 새 동물 추가 및 재정렬
        System.out.println("--- 보너스 과제: 새 동물 추가 및 정렬 ---");
        // 새 동물 "레오(호랑이, 6살)" 추가
        List<Animal> bonusAnimals = new ArrayList<>(initialAnimals);
        Animal newTiger = new Animal("레오", AnimalType.TIGER, 6);
        bonusAnimals.add(newTiger);
        System.out.println("새 동물이 추가된 목록 (" + newTiger + " 추가):");
        System.out.println(bonusAnimals);

        MigrationManager bonusManager = new MigrationManager(bonusAnimals);
        try {
            List<Animal> safeBonusSequence = bonusManager.getSafeSequence();
            System.out.println("새로 배치된 안전한 이동 순서:");
            System.out.println(safeBonusSequence);
        } catch (UnsafeSequenceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
