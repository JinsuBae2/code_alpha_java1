package course2;

public class RoadToBiodome08 {
    private static int[] queue;
    private static int front = 0;
    private static int rear = 0;
    private static int size = 0;

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 없습니다.");
            return;
        }

        // 입력 형식이 공백 또는 쉼표로 구분된 단일 문자열인 경우 분리 처리
        if (args.length == 1 && (args[0].contains(" ") || args[0].contains(","))) {
            args = args[0].replace("[", "").replace("]", "").replace(",", " ").trim().split("\\s+");
        }

        // 1. 보너스 과제 기준: 초기 크기 10으로 배열 생성 (기본과제만 하려면 100으로 생성)
        queue = new int[10];

        // 2. args 배열을 순회하며 enqueue 수행 (배열이 넘치면 enqueue 내부에서 늘려줌)
        for (int i = 0; i < args.length; i++) {
            if (args[i].trim().isEmpty())
                continue;
            try {
                int value = Integer.parseInt(args[i].trim());
                enqueue(value);
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자 형식이 아닙니다: " + args[i]);
                return;
            }
        }

        // 3. while(!isEmpty()) 돌면서 dequeue 수행 및 출력
        // 입력값의 수에 따라 기본 과제와 보너스 과제의 출력 형식을 다르게 설정합니다.
        boolean isBonusFormat = (args.length > 10);
        while (!isEmpty()) {
            int val = dequeue();
            if (isBonusFormat) {
                System.out.println("자원 제공: " + val);
            } else {
                System.out.println("자원 " + val + "을 제공했습니다.");
            }
        }
        System.out.println("모든 요청이 처리되었습니다.");
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void enqueue(int value) {
        // 꽉 찼는지 확인 -> 꽉 찼으면 새 배열 만들고 복사 후 크기 증가 출력
        if (rear == queue.length) {
            int[] newQueue = new int[queue.length + 10];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
            System.out.println("Queue의 크기가 " + queue.length + "으로 늘어났습니다.");
        }
        // 데이터 넣고 rear++, size++
        queue[rear] = value;
        rear++;
        size++;
    }

    public static int dequeue() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return -1;
        }
        int value = queue[front];
        front++;
        size--;
        return value;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return -1;
        }
        return queue[front];
    }
}
