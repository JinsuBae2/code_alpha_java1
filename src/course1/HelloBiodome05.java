package course1;

public class HelloBiodome05 {
    // [지침 2] g와 h 값을 저장하는 숫자 타입 변수 생성
    static int g = 0;
    static int h = 0;

    public static void main(String[] args) {
        HelloBiodome05 h5 = new HelloBiodome05();

        h5.findGAndH();
        System.out.println("찾은 변수 값 -> g: " + g + ", h: " + h);

        int result = h5.calculateThirdFormula();
        System.out.println("세 번째 수식 결과 값 = " + result);

        int bonusResult = h5.bonusFormula();
        System.out.println("보너스 수식 결과 값 = " + bonusResult);
    }

    public void findGAndH() {
        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 15; j++) {
                if (checkFormulas(i, j)) {
                    g = i;
                    h = j;
                    return;
                }
            }
        }
    }

    private boolean checkFormulas(int g, int h) {
        int f1 = ((g & 1) >> (g << 2)) | ((h + g) ^ h);

        int f2 = (((g % 2) << h) >> g) | (1 & 0 ^ 0);

        return (f1 == 1) && (f2 == 2);
    }

    public int calculateThirdFormula() {
        return (h * h + g) * (h << h) + (g << g);
    }

    public int bonusFormula() {

        int baseResult = (h * h + g) * (h << h) + (g << g);

        int validation = (g > h) ? (1 + 2) : (2 - 1);

        return baseResult + (validation == (2 - 1) ? (2 - 2) : (1 - 1));
    }
}
