package course2;

/** 사용자로부터 문장을 입력 받아 역순으로 출력한다.
  * 입력받은 문장에는 영어, 한글, 숫자가 포함될 수 있다.
  * 입력받는 문자열의 길이는 최소 2에서 최대 10^6승 이다.
  * 입력 값에 빈 공백만 있는 경우, "올바른 문장을 입력해주세요."와 같은 안내 메시지를 출력한다.
  */
public class RoadToBiodome02 {
    static char[] stackArray;
    static int top = -1;

    public static void push(char data) {
        top++;
        stackArray[top] = data;
    }

    public static char  pop() {
        char data = stackArray[top];
        top--;

        return data;
    }

    public static boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        if (args.length != 1 || args[0].trim().isEmpty()) {
            System.out.println("올바른 문장을 입력해주세요.");
            return;
        }

        int start = 0;
        int end = args[0].length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (args[0].charAt(start) == args[0].charAt(end)) {
                start++;
                end--;
                continue;
            } else {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(args[0]);
            return;
        }

        stackArray = new char[args[0].length()];

        for (int i = 0; i < stackArray.length; i++) {
            push(args[0].charAt(i));
        }

        while (!isEmpty()) {
            System.out.print(pop());
        }
    }
}
