package course1;

public class HelloBiodome08 {

    public static void main(String[] args) {
        if (args == null || args.length == 0 || args[0].trim().isEmpty()) {
            System.out.println("메시지가 입력되지 않았습니다.");
            return;
        }

        String input = args[0];

        if (input.length() > 100) {
            System.out.println("입력 가능한 메시지의 최대 길이는 100자입니다.");
            return;
        }

        String[] engDictionary = {
                "hello", "where", "this", "biodome", "help", "tree", "new", "is",
                "problem", "please", "need", "we", "isn't", "there", "a", "your",
                "any", "thanks", "the", "for", "solution", "can", "you"
        };

        String[] korDictionary = {
                "안녕하세요", "새로운", "나무를", "발견했습니다",
                "신속한", "지원", "감사합니다", "당신의", "도움이", "필요합니다"
        };

        char firstChar = input.charAt(0);
        String result;

        if ((firstChar >= 'a' && firstChar <= 'z') || input.contains("?")) {
            result = processSegmentation(input, engDictionary);
        } else {
            result = processSegmentation(input, korDictionary);
        }

        System.out.println(result);
    }

    public static String processSegmentation(String text, String[] dict) {
        for (int i = 0; i < dict.length - 1; i++) {
            for (int j = 0; j < dict.length - 1 - i; j++) {
                if (dict[j].length() < dict[j + 1].length()) {
                    String temp = dict[j];
                    dict[j] = dict[j + 1];
                    dict[j + 1] = temp;
                }
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder unknownBuilder = new StringBuilder();

        int i = 0;
        int length = text.length();
        boolean endsWithQuestion = text.endsWith("?");

        if (endsWithQuestion) {
            length--;
        }

        while (i < length) {
            boolean matchFound = false;
            String matchedWord = "";

            for (String word : dict) {
                if (i + word.length() <= length) {
                    String sub = text.substring(i, i + word.length());
                    if (sub.equals(word)) {
                        matchFound = true;
                        matchedWord = word;
                        break;
                    }
                }
            }

            if (matchFound) {
                if (unknownBuilder.length() > 0) {
                    resultBuilder.append(unknownBuilder).append(" ");
                    unknownBuilder.setLength(0);
                }
                resultBuilder.append(matchedWord).append(" ");
                i += matchedWord.length();
            } else {
                unknownBuilder.append(text.charAt(i));
                i++;
            }
        }

        if (unknownBuilder.length() > 0) {
            resultBuilder.append(unknownBuilder).append(" ");
        }

        String finalOutput = resultBuilder.toString().trim();

        if (endsWithQuestion) {
            finalOutput += "?";
        } else {
            finalOutput += ".";
        }

        return finalOutput;
    }
}