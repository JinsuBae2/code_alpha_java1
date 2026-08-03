package course4.ruleofbiodome06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RuleOfBiodome06 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("동물 이름을 입력해주세요.");
            return;
        }

        List<String> animalList = new ArrayList<>();

        // 쉼표를 기준으로 동물 이름 분리
        for (String arg : args) {
            String[] animals = arg.split(",");

            for (String animal : animals) {
                String animalName = animal.trim();

                if (!animalName.isEmpty()) {
                    animalList.add(animalName);
                }
            }
        }

        // 동물 데이터 개수 검사
        if (animalList.size() < 20) {
            System.out.println("동물 이름을 20개 이상 입력해주세요.");
            return;
        }

        // List를 배열로 변환
        String[] animalArray =
                animalList.toArray(new String[0]);

        // 동물 출현 빈도 분석
        AnimalFrequencyAnalyzer analyzer =
                new AnimalFrequencyAnalyzer();

        analyzer.analyze(animalArray);

        // 분석 결과 가져오기
        Set<String> mostFrequentAnimals =
                analyzer.findMostFrequentAnimals();

        Set<String> observedAnimals =
                analyzer.getObservedAnimals();

        // 결과 출력
        System.out.println("가장 많이 발견된 동물 : " + String.join(", ", mostFrequentAnimals));

        System.out.println("관찰된 모든 동물 : " + String.join(", ", observedAnimals));

        // 관찰 빈도에 따라 동물 그룹화
        Map<Integer, Set<String>> frequencyGroups =
                analyzer.groupAnimalsByFrequency();

        // 관찰 빈도를 내림차순으로 정렬
        List<Integer> frequencies =
                new ArrayList<>(frequencyGroups.keySet());
        frequencies.sort(Collections.reverseOrder());

        for (int frequency : frequencies) {
            System.out.println(frequency + "회: " + String.join(", ", frequencyGroups.get(frequency)));
        }
    }
}
