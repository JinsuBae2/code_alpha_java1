package course2;

public class RoadToBiodome06 {
    private static final int MIN_WATER_HEIGHT = 0;
    private static final int MAX_WATER_HEIGHT = 10000;

    public static void main(String[] args) {
        // 1. 입력 인자 개수 검증
        if (args.length != 2 || args[0].trim().isEmpty() || args[1].trim().isEmpty()) {
            System.out.println("올바른 두 개의 배열 입력을 입력해주세요.");
            return;
        }

        int[] n = new int[0];
        int[] m = new int[0];

        try {
            // 2. 입력 데이터 파싱 및 검증
            for (int i = 0; i < args.length; i++) {
                String cleanInput = args[i].replace("[", "")
                        .replace("]", "")
                        .replace(" ", "");

                if (cleanInput.isEmpty()) {
                    continue;
                }

                String[] tokens = cleanInput.split(",");
                int[] tempArray = new int[tokens.length];

                for (int j = 0; j < tokens.length; j++) {
                    int val = Integer.parseInt(tokens[j]);

                    // 범위 초과 예외 처리
                    if (val < MIN_WATER_HEIGHT || val > MAX_WATER_HEIGHT) {
                        System.out.println("물 높이는 " + MIN_WATER_HEIGHT + " 이상 " + MAX_WATER_HEIGHT + " 이하의 값이어야 합니다.");
                        return;
                    }
                    tempArray[j] = val;
                }

                if (i == 0) {
                    n = tempArray;
                } else {
                    m = tempArray;
                }
            }

            // [기본 과제 수행]
            // 입력 데이터가 이미 정렬되어 들어오므로 곧바로 계산 진행
            System.out.println("--- [기본 과제 결과] ---");
            printResult(n, m);

            // [보너스 과제 수행]
            // 이미 정렬된 상태에서 30 이상만 거르므로, 필터링된 배열도 자동으로 오름차순이 유지됨
            System.out.println("\n--- [보너스 과제 결과 (30 이상)] ---");
            int[] filteredN = filterAbove30(n);
            int[] filteredM = filterAbove30(m);
            printResult(filteredN, filteredM);

        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    // 평균값과 중앙값을 계산하고 지침 포맷(소수점 첫째자리 반올림)에 맞게 출력하는 메서드
    private static void printResult(int[] arr1, int[] arr2) {
        if (arr1.length == 0 && arr2.length == 0) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        double mean = calculateMean(arr1, arr2);
        double median = calculateMedian(arr1, arr2);

        System.out.printf("Mean : %.1f, Median : %.1f\n", mean, median);
    }

    // 전체 데이터의 합계를 계산해 평균값을 구하는 메서드
    public static double calculateMean(int[] arr1, int[] arr2) {
        int sum = 0;
        for (int val : arr1) sum += val;
        for (int val : arr2) sum += val;

        return (double) sum / (arr1.length + arr2.length);
    }

    // 짝수/홀수 여부에 따라 중앙값을 계산하는 메서드
    public static double calculateMedian(int[] arr1, int[] arr2) {
        // 더 작은 배열을 arr1로 설정하여 이진 탐색 최적화
        if (arr1.length > arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        int low = 0;
        int high = arr1.length;
        int totalLength = arr1.length + arr2.length;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (totalLength + 1) / 2 - i;

            int A_left = (i == 0) ? Integer.MIN_VALUE : arr1[i - 1];
            int A_right = (i == arr1.length) ? Integer.MAX_VALUE : arr1[i];
            int B_left = (j == 0) ? Integer.MIN_VALUE : arr2[j - 1];
            int B_right = (j == arr2.length) ? Integer.MAX_VALUE : arr2[j];

            // 이진 탐색 포인터 이동 (Up/Down 구조)
            if (A_left > B_right) {
                high = i - 1; // A에서 너무 많이 가져왔으므로 범위를 왼쪽으로 줄임
            } else if (B_left > A_right) {
                low = i + 1;  // A에서 너무 적게 가져왔으므로 범위를 오른쪽으로 늘림
            } else {
                // 완벽한 분할선을 찾은 경우
                int maxLeft = (A_left > B_left) ? A_left : B_left;

                // 홀수 개수인 경우 왼쪽 그룹의 최댓값이 중앙값
                if (totalLength % 2 != 0) {
                    return maxLeft;
                }

                // 짝수 개수인 경우 중앙에 위치한 두 값의 평균 사용
                int minRight = (A_right < B_right) ? A_right : B_right;
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    // 배열에서 30 이상인 값만 추출하여 새로운 배열을 반환하는 메서드
    private static int[] filterAbove30(int[] arr) {
        int count = 0;
        for (int val : arr) {
            if (val >= 30) count++;
        }

        int[] filtered = new int[count];
        int index = 0;
        for (int val : arr) {
            if (val >= 30) {
                filtered[index++] = val;
            }
        }
        return filtered;
    }
}