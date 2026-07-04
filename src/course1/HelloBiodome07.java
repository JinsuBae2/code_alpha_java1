package course1;

public class HelloBiodome07 {
    final static String a = "CYJEH";
    static int [] cnt = new int[5];

    public static void main(String[] args) {
        HelloBiodome07 h7 =  new HelloBiodome07();
        String code;
        code = args[0];

        String print =  h7.codeReturn(code);

    }

    public String codeReturn(String seq) {
            seq = seq.toUpperCase();

            String cleanedSeq = "";
            boolean lastWasSpace = false;

            for (int i = 0; i < seq.length(); i++) {
                char ch = seq.charAt(i);
                if (ch == ' ') {
                    if (!lastWasSpace) {
                        cleanedSeq += ch;
                        lastWasSpace = true;
                    }
                } else {
                    cleanedSeq += ch;
                    lastWasSpace = false;
                }
            }

            if (cleanedSeq.trim().isEmpty()) {
                return "염기서열이 입력되지 않았습니다.";
            }

            for (int i = 0; i < cleanedSeq.length(); i++) {
                char ch = cleanedSeq.charAt(i);
                if (ch != 'C' && ch != 'Y' && ch != 'J' && ch != 'E' && ch != 'H' && ch != ' ') {
                    return "염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요";
                }
            }

            String compressed = "";
            char target = cleanedSeq.charAt(0);
            int count = 1;

            for (int i = 1; i < cleanedSeq.length(); i++) {
                char current = cleanedSeq.charAt(i);

                if (current == target) {
                    count++;
                } else {
                    if (target == ' ') {
                        compressed += " ";
                    } else {
                        compressed += target + "" + count;
                    }

                    target = current;
                    count = 1;
                }
            }

            if (target == ' ') {
                compressed += " ";
            } else {
                compressed += target + "" + count;
            }

            return compressed;
    }
}
