package course2;

public class RoadToBiodome02 {
    static char[] stackArray;
    static int top = -1;

    public static void push(char data) {
        top++;
        stackArray[top] = data;
    }

    public static char pop() {
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
