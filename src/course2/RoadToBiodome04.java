package course2;

public class RoadToBiodome04 {

    public static void selectionSort(double[] nums) {
        int minIdx = 0;
        double temp = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIdx] > nums[j]) {
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;
            }
        }
    }

    public static double getAverage(double[] arr) {
        double average = 0;
        for (double num : arr) {
            average += num;
        }
        return average / arr.length;
    }

    public static double getMedian(double[] arr) {
        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        } else {
            return (arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 없습니다.");
            return;
        }

        double[] medians = new double[args.length];
        double[] currentNums = new double[0];
        try {
            for (int i = 0; i < args.length; i++) {
                String cleanInput = args[i].replace("[", "")
                        .replace("]", "")
                        .replace(" ", "");

                String[] tokens = cleanInput.split(",");

                currentNums = new double[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    currentNums[j] = Double.parseDouble(tokens[j]);
                }

                selectionSort(currentNums);
                medians[i] = getMedian(currentNums);
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식이 올바르지 않습니다. 확인 후 다시 입력해 주세요.");
            return;
        }

        if (args.length == 1) {
            double avg = getAverage(currentNums);
            double median = medians[0];

            System.out.println("평균값 : " + avg + ", 중앙값 : " + median);
        } else {
            // 인자가 여러 개일 때는 보너스 과제 양식으로 출력 (중앙값 나열)
            for (int i = 0; i < medians.length; i++) {
                System.out.print(medians[i]);
                if (i < medians.length - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }
}