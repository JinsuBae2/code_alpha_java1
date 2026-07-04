package course1;

public class HelloBiodome09 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        int height = 0;
        try {
            height = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        if (height < 3 || height > 100) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        char decoChar = '*';
        if (args.length > 1 && !args[1].isEmpty()) {
            decoChar = args[1].charAt(0);
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - 1 - i; j++) {
                System.out.print(" ");
            }

            int totalChars = 2 * i + 1;
            int centerIndex = totalChars / 2;

            for (int k = 0; k < totalChars; k++) {
                if (k == centerIndex && decoChar != '*') {
                    System.out.print(decoChar);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        for (int j = 0; j < height - 1; j++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}
