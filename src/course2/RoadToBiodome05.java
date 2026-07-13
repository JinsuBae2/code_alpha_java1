package course2;

import java.util.Arrays;

public class RoadToBiodome05 {

    // 1. 퀵 정렬 (Quick Sort)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗을 기준으로 배열을 분할하고, 피벗의 최종 위치를 반환받음
            int pivotIdx = partition(arr, low, high);

            // 피벗을 제외한 왼쪽 그룹과 오른쪽 그룹을 재귀적으로 정렬
            quickSort(arr, low, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, high);
        }
    }

    // 퀵 정렬의 핵심: 피벗을 기준으로 좌우를 분할하는 메서드
    private static int partition(int[] arr, int low, int high) {
        // 맨 오른쪽 원소를 피벗(기준값)으로 설정
        int pivot = arr[high];
        int i = (low - 1); // 피벗보다 작은 원소들이 들어갈 자리를 가리키는 포인터

        for (int j = low; j < high; j++) {
            // 현재 원소가 피벗보다 작거나 같으면 포인터를 이동하고 자리를 바꿈
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 루프가 끝난 후, 피벗(arr[high])을 작은 원소들 바로 다음 칸(i + 1)과 교환
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 피벗의 최종 위치 인덱스 반환
    }

    // 2. 보너스 과제: 버블 정렬 (Bubble Sort)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // 인접한 두 원소를 비교하여 앞의 것이 더 크면 Swap
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 인자가 정확히 2개 들어왔는지 확인
        if (args == null || args.length != 2) {
            System.out.println("올바른 두 개의 배열을 입력해 주세요. 예: \"[1,2]\" \"[3,4]\"");
            return;
        }

        try {
            // 첫 번째 배열 파싱
            String cleanInput1 = args[0].replace("[", "").replace("]", "").replace(" ", "");
            String[] tokens1 = cleanInput1.split(",");
            int[] arr1 = new int[tokens1.length];
            for (int i = 0; i < tokens1.length; i++) {
                arr1[i] = Integer.parseInt(tokens1[i]);
                if (arr1[i] < 0) { // 제약사항: 최소 0 이상의 값
                    System.out.println("물 높이는 음수일 수 없습니다.");
                    return;
                }
            }

            // 두 번째 배열 파싱
            String cleanInput2 = args[1].replace("[", "").replace("]", "").replace(" ", "");
            String[] tokens2 = cleanInput2.split(",");
            int[] arr2 = new int[tokens2.length];
            for (int i = 0; i < tokens2.length; i++) {
                arr2[i] = Integer.parseInt(tokens2[i]);
                if (arr2[i] < 0) {
                    System.out.println("물 높이는 음수일 수 없습니다.");
                    return;
                }
            }

            // 두 배열을 하나로 합치기 (통합 배열 생성)
            int[] combinedNums = new int[arr1.length + arr2.length];

            // arr1 복사
            for (int i = 0; i < arr1.length; i++) {
                combinedNums[i] = arr1[i];
            }
            // arr2 복사 (arr1이 끝난 지점부터 이어서 저장)
            for (int i = 0; i < arr2.length; i++) {
                combinedNums[arr1.length + i] = arr2[i];
            }

            // 과제 요구사항: 퀵 정렬 수행
            quickSort(combinedNums, 0, combinedNums.length - 1);

            // (보너스 과제 테스트 시 아래 주석을 풀고 quickSort를 주석 처리하면 됩니다)
            // bubbleSort(combinedNums);

            System.out.print("[");
            for (int i = 0; i < combinedNums.length; i++) {
                System.out.print(combinedNums[i]);
                if (i < combinedNums.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");

        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값이 포함되어 있습니다. 입력 값을 확인해 주세요.");
        } catch (Exception e) {
            System.out.println("알 수 없는 오류가 발생했습니다.");
        }
    }
}