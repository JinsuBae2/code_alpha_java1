package course6.runbiodome04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class FruitStore {
    private Map<String, Integer> stockMap = new LinkedHashMap<>();
    private Map<String, List<String>> historyMap = new LinkedHashMap<>();
    private final Path filePath = Paths.get("src/course6/runbiodome04/fruit_data_total.csv");

    // CSV 파일 읽기
    public void loadData() {
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.skip(1).forEach(line -> {
                String[] tokens = line.split(",");
                if (tokens.length >= 2) {
                    String name = tokens[0].trim();
                    int stock = Integer.parseInt(tokens[1].trim());
                    stockMap.put(name, stock);

                    List<String> historyList = new ArrayList<>();
                    for (int i = 2; i < tokens.length; i++) {
                        historyList.add(tokens[i].trim());
                    }
                    historyMap.put(name, historyList);
                }
            });
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 헬퍼: 과일별 총 판매량 계산
    private int getTotalSalesForFruit(String fruit) {
        List<String> history = historyMap.getOrDefault(fruit, Collections.emptyList());
        return history.stream()
                .mapToInt(h -> Integer.parseInt(h.split(":")[1]))
                .sum();
    }

    // 1. 모든 과일 재고 조회하기
    public void printAllStock() {
        System.out.println("\n모든 과일의 재고량:");
        stockMap.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + "개"));
    }

    // 2. 가장 많이 팔린 과일 조회하기
    public void printMostSoldFruit() {
        historyMap.keySet().stream()
                .max(Comparator.comparingInt(this::getTotalSalesForFruit))
                .ifPresent(maxFruit -> {
                    int maxSales = getTotalSalesForFruit(maxFruit);
                    System.out.println("\n가장 많이 팔린 과일: " + maxFruit + " - 총 " + maxSales + "개 판매됨");
                });
    }

    // 3. 총 판매 과일 수 조회하기
    public void printTotalSalesCount() {
        int totalSales = historyMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(h -> Integer.parseInt(h.split(":")[1]))
                .sum();
        System.out.println("\n총 판매된 과일 수: " + totalSales + "개");
    }

    // 4. 과일별 평균 판매 개수 조회하기 (소수 첫째자리 반올림)
    public void printAverageSalesPerFruit() {
        System.out.println("\n과일별 평균 판매 개수:");
        historyMap.forEach((fruit, historyList) -> {
            double avg = historyList.stream()
                    .mapToInt(h -> Integer.parseInt(h.split(":")[1]))
                    .average()
                    .orElse(0.0);
            System.out.printf("%s - %.1f개\n", fruit, avg);
        });
    }

    // 5. 과일별 판매 조회 (보너스 과제: 날짜 오름차순 정렬 후 한줄씩 출력 및 총 판매 개수 출력)
    public void printFruitSalesDetail(String fruit) {
        if (!historyMap.containsKey(fruit)) {
            System.out.println("\n존재하지 않는 과일입니다.");
            return;
        }

        System.out.println("\n" + fruit + " 날짜별 판매 이력:");
        historyMap.get(fruit).stream()
                .sorted(Comparator.comparing(h -> h.split(":")[0]))
                .forEach(h -> {
                    String[] parts = h.split(":");
                    System.out.println(parts[0] + " " + parts[1] + "개");
                });

        int total = getTotalSalesForFruit(fruit);
        System.out.println("총 판매 개수: " + total + "개");
    }
}
