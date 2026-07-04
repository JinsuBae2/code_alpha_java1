package course1;

public class HelloBiodome02 {
    public static void main(String[] args) {
        int sun = 0;
        int wind = 0;
        int land = 0;
        if (args.length == 0) {
            System.out.println("에너지 생산량을 입력해주세요");
            return;
        }

        try {
            sun = Integer.parseInt(args[0]);
            wind = Integer.parseInt(args[1]);
            land = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
            return;
        }

        if (sun < 0 || sun > 30000 || wind < 0 || wind > 30000 || land < 0 || land > 30000) {
            System.out.println("에너지 생산량은 0 이상 30,000 이하의 정수여야 합니다.");
            return;
        }

        int sum = sun + wind + land;
        System.out.println("총 에너지 사용량은 " + sum + "입니다.");

        if (sum == 0) {
            System.out.println("총 에너지 생산량이 0이므로 비율을 계산할 수 없습니다.");
            return;
        }

        double sunPer = ((double) sun / sum) * 100;
        double windPer = ((double) wind / sum) * 100;
        double landPer = ((double) land / sum) * 100;

        System.out.println("태양광 : " + sunPer + "% 풍력 : " + windPer + "% 지열 : " + landPer + "%");
    }
}
