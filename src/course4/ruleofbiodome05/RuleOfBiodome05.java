package course4.ruleofbiodome05;

public class RuleOfBiodome05 {
    public static void main(String[] args) {
        // 1. 문자열 형태의 식물 이름과 특징을 관리하는 해시맵 생성
        PlantHashMap<String, String> plantMap = new PlantHashMap<>();

        // 2. 해시 인덱스를 이용해 식물 데이터 10개 저장
        plantMap.put("장미", "장미는 관상용으로 많이 재배되는 화초 중 하나이다.");
        plantMap.put("해바라기", "해바라기는 태양을 따라 움직이는 것으로 알려져 있다.");
        plantMap.put("민들레", "민들레는 약용으로도 사용되는 풀이다.");
        plantMap.put("튤립", "튤립은 다양한 색상의 꽃을 피우는 구근 식물이다.");
        plantMap.put("선인장", "선인장은 건조한 환경에 적응한 다육 식물이다.");
        plantMap.put("라벤더", "라벤더는 향기가 강해 향료로 많이 사용된다.");
        plantMap.put("무궁화", "무궁화는 여름부터 가을까지 꽃을 피운다.");
        plantMap.put("소나무", "소나무는 사계절 푸른 잎을 유지하는 침엽수이다.");
        plantMap.put("단풍나무", "단풍나무는 가을에 잎이 붉게 물드는 나무이다.");
        plantMap.put("수국", "수국은 토양의 성질에 따라 꽃 색깔이 달라질 수 있다.");
        System.out.println();

        // 3. 식물 이름을 키로 사용해 특징 조회
        plantMap.get("장미");
        plantMap.get("해바라기");
        System.out.println();

        // 4. 식물 이름을 키로 사용해 저장된 정보 삭제
        plantMap.remove("민들레");
        System.out.println();

        // 5. 식물 이름의 해시값으로 계산된 배열 인덱스 출력
        plantMap.getIndexInfo("장미");
        plantMap.getIndexInfo("해바라기");
        System.out.println();

        // 6. 동일한 해시값을 가진 키로 체이닝 동작 검증
        String str1 = "0-42L";
        String str2 = "0-43-";

        plantMap.put(str1, "첫 번째 충돌 데이터");
        plantMap.put(str2, "두 번째 충돌 데이터");
        plantMap.getIndexInfo(str1);
        plantMap.getIndexInfo(str2);
        System.out.println();

        // 7. 같은 버킷에 연결된 두 데이터를 각각 조회
        plantMap.get(str1);
        plantMap.get(str2);
        System.out.println();

        // 8. 첫 노드를 삭제해도 다음 노드가 유지되는지 확인
        plantMap.remove(str1);
        plantMap.get(str2);
    }
}
