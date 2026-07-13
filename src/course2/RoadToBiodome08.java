package course2;

public class RoadToBiodome08 {
    // 큐 관리를 위한 클래스 레벨의 static 변수들
    private static int[] queue;
    private static int front = 0;
    private static int rear = 0;
    private static int size = 0;

    public static void main(String[] args) {
        // 1. 보너스 과제 기준: 초기 크기 10으로 배열 생성 (기본과제만 하려면 100으로 생성)
        queue = new int[10];
        // 2. args 배열을 순회하며 enqueue 수행 (배열이 넘치면 enqueue 내부에서 늘려줌)
        for (int i = 0; i < ; i++) {

        }
        // 3. while(!isEmpty()) 돌면서 dequeue 수행 및 출력
    }

    public static boolean isEmpty() { }
    public static void enqueue(int value) {
        // 꽉 찼는지 확인 -> 꽉 찼으면 새 배열 만들고 복사 후 크기 증가 출력
        // 데이터 넣고 rear++, size++
    }
    public static int dequeue() { }
    public static int peek() { }
}
