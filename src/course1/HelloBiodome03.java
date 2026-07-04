package course1;

import java.util.Arrays;

public class HelloBiodome03 {
    final static double PI= 3.14;
    final static double PRECISION = 0.0000000001;
    final static double COEF = 0.415;
    public static void main(String[] args) {
        double temp = 0;
        double hum = 0;
        double oxygen = 0;

        HelloBiodome03 h = new HelloBiodome03();

        if (args.length < 3) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서대로 숫자 값을 입력해주세요");
            return;
        }

        try {
            temp = Double.parseDouble(args[0]);
            hum = Double.parseDouble(args[1]);
            oxygen = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
            return;
        }

        hum = h.rootHum(hum);
        double humTemp = h.abs(hum, temp);
        double lifeIndex = h.lifeIndex(humTemp, oxygen);

        System.out.printf("생명지수 : %.3f\n",lifeIndex);



    }

    public double rootHum(double hum){
        if (hum == 0) return 0.0;
        double x = hum;
        int cnt = 0;
        while (true) {
            double diff = (x * x) - hum;
            double absDiff = (diff < 0) ? -diff : diff;

            if (absDiff < PRECISION) {
                break;
            }
            x = (x + (hum / x)) / 2.0;
        }
        return x;
    }

    public double abs(double hum, double temp) {
        return (hum - temp) > 0 ? hum - temp : -(hum - temp);
    }

    public double lifeIndex(double humTemp, double oxygen) {
        return COEF * humTemp + (oxygen / (PI * PI));
    }
}
