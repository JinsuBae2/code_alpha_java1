package course2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class RoadToBiodome01 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 없습니다.");
            return;
        }

        List<Integer> inputList = new ArrayList<>();

        String combined = "";
        for (String arg : args) {
            combined += arg + " ";
        }

        combined = combined.replace("[", "").replace("]", "").replace(",", " ");
        String[] tokens = combined.split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            try {
                int num = Integer.parseInt(token);

                if (num < 0 || num > 1000) {
                    System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                    return;
                }
                inputList.add(num);
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자 형식이 아닙니다.");
                return;
            }
        }

        int finalNum = 0;

        BiFunction<List<Integer>, Integer, Integer> count0 = (list, target) -> {
            int count = 0;
            for (int num : list) {
                if (num == target) {
                    count++;
                }
            }
            return count;
        };

        for (int i = 0; i < inputList.size(); i++) {
            int current = inputList.get(i);

            int count = count0.apply(inputList, current);

            if (count == 1) {
                finalNum = current;
                break;
            }
        }

        System.out.println(finalNum);
    }
}