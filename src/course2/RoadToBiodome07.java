package course2;

public class RoadToBiodome07 {
    public static void main(String[] args) {
        if (args.length != 1 || args[0].trim().isEmpty()) {
            System.out.println("입력 데이터가 비어있습니다.");
            return;
        }

        String cleanInput = args[0].replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .replace(" ", "");

        String[] inputs = cleanInput.split(",");

        for (String animal : inputs) {
            if (animal.matches(".*\\d.*")) {
                System.out.println("동물 이름에 숫자값이 포함되어 있습니다.");
                return;
            }
        }

        // 2. 고유 동물 배열 및 빈도수 배열 생성 및 계산
        String[] uniqueAnimals = new String[inputs.length];
        int[] frequencies = new int[inputs.length];
        int uniqueCount = 0;

        uniqueCount = calculateFrequency(inputs, uniqueAnimals, frequencies);

        // --- 3. 기본 정렬 알고리즘 수행 (선택 정렬) 및 출력 ---
        String[] selectSortedAnimals = new String[uniqueCount];
        int[] selectSortedFreq = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            selectSortedAnimals[i] = uniqueAnimals[i];
            selectSortedFreq[i] = frequencies[i];
        }

        selectionSort(selectSortedFreq, uniqueCount, selectSortedAnimals);

        System.out.print("기본 정렬(선택 정렬) 결과:\n→ ");
        printArray(selectSortedAnimals, uniqueCount);


        // --- 4. [보너스 과제] 병합 정렬(Merge Sort) 수행 및 출력 ---
        String[] mergeSortedAnimals = new String[uniqueCount];
        int[] mergeSortedFreq = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            mergeSortedAnimals[i] = uniqueAnimals[i];
            mergeSortedFreq[i] = frequencies[i];
        }

        // 병합 정렬 시작 (인덱스 0부터 uniqueCount - 1까지)
        mergeSort(mergeSortedFreq, mergeSortedAnimals, 0, uniqueCount - 1);

        System.out.print("\n보너스 과제(병합 정렬) 결과:\n→ ");
        printArray(mergeSortedAnimals, uniqueCount);
    }

    /**
     * 배열을 정해진 포맷으로 출력하는 헬퍼 메서드
     */
    private static void printArray(String[] arr, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * 기본 과제: 선택 정렬 알고리즘
     */
    private static void selectionSort(int[] frequencies, int uniqueCount, String[] uniqueAnimals) {
        int tempN;
        String tempS;

        for (int i = 0; i < uniqueCount - 1; i++) {
            for (int j = i + 1; j < uniqueCount; j++) {
                if (frequencies[i] < frequencies[j] ||
                        (frequencies[i] == frequencies[j] && uniqueAnimals[i].compareTo(uniqueAnimals[j]) > 0)) {

                    tempN = frequencies[i];
                    frequencies[i] = frequencies[j];
                    frequencies[j] = tempN;

                    tempS = uniqueAnimals[i];
                    uniqueAnimals[i] = uniqueAnimals[j];
                    uniqueAnimals[j] = tempS;
                }
            }
        }
    }

    /**
     * 보너스 과제: 병합 정렬 분할(Divide) 메서드
     */
    private static void mergeSort(int[] frequencies, String[] uniqueAnimals, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 반으로 쪼개서 각각 정렬
            mergeSort(frequencies, uniqueAnimals, left, mid);
            mergeSort(frequencies, uniqueAnimals, mid + 1, right);

            // 정렬된 두 부분을 병합
            merge(frequencies, uniqueAnimals, left, mid, right);
        }
    }

    /**
     * 보너스 과제: 병합 정렬 병합(Merge) 및 다중 조건 비교 메서드
     */
    private static void merge(int[] frequencies, String[] uniqueAnimals, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 임시 임시 배열 생성
        int[] L_freq = new int[n1];
        int[] R_freq = new int[n2];
        String[] L_anim = new String[n1];
        String[] R_anim = new String[n2];

        // 데이터 복사
        for (int i = 0; i < n1; i++) {
            L_freq[i] = frequencies[left + i];
            L_anim[i] = uniqueAnimals[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R_freq[j] = frequencies[mid + 1 + j];
            R_anim[j] = uniqueAnimals[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        // 다중 조건(빈도수 내림차순, 이름 가나다순 오름차순)을 비교하며 병합
        while (i < n1 && j < n2) {
            boolean takeLeft = false;

            if (L_freq[i] > R_freq[j]) {
                takeLeft = true;
            } else if (L_freq[i] == R_freq[j]) {
                if (L_anim[i].compareTo(R_anim[j]) <= 0) {
                    takeLeft = true;
                }
            }

            if (takeLeft) {
                frequencies[k] = L_freq[i];
                uniqueAnimals[k] = L_anim[i];
                i++;
            } else {
                frequencies[k] = R_freq[j];
                uniqueAnimals[k] = R_anim[j];
                j++;
            }
            k++;
        }

        // 남은 원소들 복사
        while (i < n1) {
            frequencies[k] = L_freq[i];
            uniqueAnimals[k] = L_anim[i];
            i++;
            k++;
        }
        while (j < n2) {
            frequencies[k] = R_freq[j];
            uniqueAnimals[k] = R_anim[j];
            j++;
            k++;
        }
    }

    /**
     * 빈도수 계산 메서드
     */
    private static int calculateFrequency(String[] inputs, String[] uniqueAnimals, int[] frequencies) {
        int uniqueCount = 0;

        for (String animal : inputs) {
            int foundIndex = -1;

            for (int i = 0; i < uniqueCount; i++) {
                if (uniqueAnimals[i].equals(animal)) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex != -1) {
                frequencies[foundIndex]++;
            } else {
                uniqueAnimals[uniqueCount] = animal;
                frequencies[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}

/* ========================================================================
 * [보너스 과제: 정렬 알고리즘 시간 복잡도 비교 분석]
 *
 * 1. 기존 방식 (선택 정렬 - Selection Sort)
 * - 시간 복잡도: 최선, 평균, 최악의 경우 모두 O(N^2)
 * - 분석: 고유 동물 수가 N개일 때, 이중 for 루프를 수행하므로 데이터의 정렬 상태와
 * 상관없이 항상 N*(N-1)/2번의 비교 연산이 일어납니다. 고유 동물의 종류가
 * 많아질수록 성능이 급격히 저하됩니다.
 *
 * 2. 보너스 방식 (병합 정렬 - Merge Sort)
 * - 시간 복잡도: 최선, 평균, 최악의 경우 모두 O(N log N)
 * - 분석: 분할 정복(Divide and Conquer) 패러다임을 사용하여 배열을 매번 반으로 쪼갠 뒤
 * 합병합니다. 쪼개는 깊이가 log N이며, 각 층마다 N번의 비교/병합 연산이 수행되므로
 * 항상 일정한 O(N log N)의 뛰어난 성능을 보장합니다.
 *
 * 3. 결론 및 비교
 * - N의 크기가 작을 때는 큰 차이가 없으나, 관찰되는 고유 동물의 종류(N)가 대규모로
 * 늘어날수록 O(N^2)의 선택 정렬보다 O(N log N)의 병합 정렬이 압도적으로 효율적입니다.
 * - 다만, 병합 정렬은 병합 과정에서 임시 배열(L_freq, R_freq 등)을 새로 생성하므로
 * O(N) 만큼의 추가적인 메모리 공간(공간 복잡도)이 필요하다는 단점이 있습니다.
 * ======================================================================== */