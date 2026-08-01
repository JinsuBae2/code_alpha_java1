package course4.ruleofbiodome04;

public class RuleOfBiodome04 {
    public static void main(String[] args) {
        // 1. 동물 정보 생성
        BiologicalEntity<AnimalFeature> cat = new BiologicalEntity<>(
                "고양이", "동물",
                new AnimalFeature("귀여움", "태생", "대형 맹금류", "쥐", "20년"));
        BiologicalEntity<AnimalFeature> zebra = new BiologicalEntity<>(
                "얼룩말", "동물",
                new AnimalFeature("잘 달린다", "태생", "사자", "풀", "10년"));

        // 2. 식물 정보 생성
        BiologicalEntity<PlantFeature> rosemary = new BiologicalEntity<>(
                "로즈마리", "식물",
                new PlantFeature("보라색", false, "7월"));
        BiologicalEntity<PlantFeature> cherryBlossom = new BiologicalEntity<>(
                "벚꽃", "식물",
                new PlantFeature("분홍색", true, "3월"));

        // 3. 미생물 정보 생성
        BiologicalEntity<MicrobeFeature> eColi = new BiologicalEntity<>(
                "이콜라이", "미생물",
                new MicrobeFeature("약 산성", true, "호흡 및 발효 대사"));
        BiologicalEntity<MicrobeFeature> bacillus = new BiologicalEntity<>(
                "바실러스", "미생물",
                new MicrobeFeature("약 산성", false, "호흡 대사"));

        // 4. 생성된 생물 정보 확인
        System.out.println(cat);
        System.out.println(zebra);
        System.out.println(rosemary);
        System.out.println(cherryBlossom);
        System.out.println(eColi);
        System.out.println(bacillus);
        System.out.println();

        // 5. 서로 다른 특징 타입을 하나의 시스템에서 관리
        BiologicalSystem<Feature> biologicalSystem = new BiologicalSystem<>();
        System.out.println();

        // 6. 생물 정보를 등록 순서대로 추가
        biologicalSystem.add(cat);
        biologicalSystem.add(zebra);
        biologicalSystem.add(rosemary);
        biologicalSystem.add(cherryBlossom);
        biologicalSystem.add(eColi);
        biologicalSystem.add(bacillus);
        System.out.println();

        // 7. 가장 최근에 등록된 생물 삭제
        biologicalSystem.delete();
        System.out.println();

        // 8. 삭제 후 가장 최근에 등록된 생물 조회
        biologicalSystem.show();
        System.out.println();

        // 9. 전체 삭제 전 생물 정보 존재 여부 확인
        biologicalSystem.isEmpty();
        System.out.println();

        // 10. 남아 있는 생물 정보를 이름순으로 정렬
        biologicalSystem.sortByName();
        System.out.println();

        // 11. 모든 생물 정보 삭제
        biologicalSystem.clear();
        System.out.println();

        // 12. 전체 삭제 후 생물 정보 존재 여부 확인
        biologicalSystem.isEmpty();
    }
}
