package course1;

public class HelloBiodome06 {
    public static void main(String[] args) {
        String c1;
        String c2;
        int i = 0;

        if (args.length != 2) {
            System.out.println("두 개의 유전자 코드를 입력해주세요");
            return;
        }
        c1 = args[0];
        c2 = args[1];

        if ((c1.length() < 5 || c1.length() > 20) || (c2.length() < 5 || c2.length() > 20)) {
            System.out.println("유전자 코드는 5개 이상 20개 이하입니다.");
            return;
        }

        boolean isExactMatch = false;
        if (c1.length() == c2.length()) {
            while (i != c1.length()) {
                if (c1.charAt(i) == c2.charAt(i)) {
                    i++;
                } else {
                    break;
                }
            }
            if (i == c1.length()) {
                isExactMatch = true;
            }
        }

        if (isExactMatch) {
            System.out.println("동일한 유전자 코드입니다.");
        } else {
            System.out.println("일치하지 않습니다.");

            boolean isContained = false;

            if (c1.length() <= c2.length()) {
                int startIdx = 0;
                while (startIdx <= c2.length() - c1.length()) {
                    int matchCount = 0;

                    while (matchCount < c1.length()) {
                        if (c1.charAt(matchCount) == c2.charAt(startIdx + matchCount)) {
                            matchCount++;
                        } else {
                            break;
                        }
                    }

                    if (matchCount == c1.length()) {
                        isContained = true;
                        break;
                    }

                    startIdx++;
                }
            }

            if (isContained) {
                System.out.println("부분적으로 포함됩니다.");
            } else {
                System.out.println("포함되지 않습니다.");
            }
        }
    }
}