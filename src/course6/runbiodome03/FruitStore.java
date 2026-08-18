package course6.runbiodome03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FruitStore {
    private Map<String, Integer> stockMap = new LinkedHashMap<>();
    private Map<String, String> historyMap = new LinkedHashMap<>();
    private final Path filePath = Paths.get("src/course6/runbiodome03/fruit_data.csv");

    public void loadData() {
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.skip(1).forEach(line -> {
                String[] tokens = line.split(",");
                if (tokens.length >= 3) {
                    String name = tokens[0].trim();
                    int count = Integer.parseInt(tokens[1].trim());
                    String history = tokens[2].trim();

                    stockMap.put(name, count);
                    historyMap.put(name, history);
                }
            });
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public void saveData() {
        try {
            List<String> lines = new ArrayList<>();
            lines.add("과일명,재고량,최근 판매 정보");

            for (String name : stockMap.keySet()) {
                String line = name + "," + stockMap.get(name) + "," + historyMap.getOrDefault(name, "");
                lines.add(line);
            }
            Files.write(filePath, lines);
            System.out.println("\n모든 데이터가 저장되었습니다. 과일 상점 관리 시스템을 종료합니다!");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 1. 과일 판매 메서드
    public void sellFruit(String name, int quantity) {
        if (!stockMap.containsKey(name)) {
            System.out.println("\n목록에 존재하지 않는 과일입니다.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("\n수량은 0보다 커야 합니다.");
            return;
        }
        int currentStock = stockMap.get(name);
        if (currentStock < quantity) {
            System.out.println("\n재고가 부족하여 주문을 처리할 수 없습니다.");
            return;
        }

        stockMap.put(name, currentStock - quantity);
        String today = LocalDate.now().toString();
        historyMap.put(name, today + ":" + quantity);

        System.out.println("\n" + name + " " + quantity + "개가 판매되었습니다!");
    }

    // 2. 과일 재고 추가 메서드
    public void addStock(String name, int quantity) {
        if (!stockMap.containsKey(name)) {
            System.out.println("\n목록에 존재하지 않는 과일입니다.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("\n추가할 수량은 0보다 커야 합니다.");
            return;
        }

        stockMap.put(name, stockMap.get(name) + quantity);
        System.out.println("\n" + name + " 재고가 " + quantity + "개 추가되었습니다!");
    }

    // 3. 모든 과일 재고 조회 메서드 (Stream API 활용)
    public void printAllStock() {
        System.out.println("\n모든 과일 재고 조회:");
        stockMap.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + "-" + entry.getValue() + "개"));
    }

    // 4. 최근 판매 기록 조회 메서드 (보너스 과제)
    public void printRecentHistory(String name) {
        if (!historyMap.containsKey(name)) {
            System.out.println("\n목록에 존재하지 않는 과일입니다.");
            return;
        }
        String history = historyMap.get(name);
        if (history == null || history.isEmpty()) {
            System.out.println("\n" + name + "의 판매 기록이 없습니다.");
            return;
        }
        String[] parts = history.split(":");
        if (parts.length >= 2) {
            System.out.println("\n" + name + " 최근 판매 기록 조회:");
            System.out.println(parts[0] + " " + parts[1] + "개");
        } else {
            System.out.println("\n" + name + " 최근 판매 기록: " + history);
        }
    }
}

