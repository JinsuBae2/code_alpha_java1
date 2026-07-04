package course1;

public class HelloBiodome04 {
    static int sig = 0;
    public static void main(String[] args) {
        double t;
        double h;
        double o;

        try {
            t = Double.parseDouble(args[0]);
            h = Double.parseDouble(args[1]);
            o = Double.parseDouble(args[2]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서대로 숫자 값을 입력해주세요");
            return;
        }

        boolean isValueIndex = isValueIndex(t, h, o);
        if (isValueIndex) {
            System.out.println("생명의 나무는 안정적인 상태입니다 :)");
        }

        switch (sig) {
            case 1 :
                System.out.println("온도값이 정상 범위를 벗어났습니다. 확인이 필요합니다");
                break;
            case 2:
                System.out.println("습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다");
                break;
            case 3:
                System.out.println("산소값이 정상 범위를 벗어났습니다. 확인이 필요합니다");
        }
    }

    public static boolean isValueIndex(double t, double h, double o){
        if (t < 10 || t >= 27.5) {
            sig = 1;
            return false;
        } else if (h <= 40 || h >= 60) {
            sig = 2;
            return false;
        } else if (o < 19.5 || o > 23.5) {
            sig = 3;
            return false;
        }
        return true;
    }
}
