package course2;

import java.util.LinkedList;
import java.util.Queue;

public class RoadToBiodome10 {

    public static void main(String[] args) {
        // 1. 입력 데이터 존재 여부 확인
        if (args == null || args.length == 0) {
            System.out.println("입력 데이터가 비어있습니다.");
            return;
        }

        // 공백으로 구분된 단일 문자열로 인자가 전달된 경우 분리 처리
        if (args.length == 1 && args[0].contains(" ")) {
            args = args[0].trim().split("\\s+");
        }

        // 2. 그래프 인접 행렬 및 방문/존재 여부 배열 초기화 (식물 번호 1~100)
        boolean[][] graph = new boolean[101][101];
        boolean[] visited = new boolean[101];
        boolean[] isExist = new boolean[101]; // 실제 입력에 등장한 식물 체크

        // 3. 입력 데이터 파싱 및 유효성 검사
        for (String pair : args) {
            if (!pair.contains(",")) {
                System.out.println("입력값에 문자가 포함되어 있거나 올바른 연관관계 형식이 아닙니다.");
                return;
            }

            String[] parts = pair.split(",");
            if (parts.length != 2) {
                System.out.println("입력값에 문자가 포함되어 있거나 올바른 연관관계 형식이 아닙니다.");
                return;
            }

            int u, v;
            try {
                u = Integer.parseInt(parts[0].trim());
                v = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("입력값에 문자가 포함되어 있습니다.");
                return;
            }

            // 식물 번호 범위 검증 (1 ~ 100)
            if (u < 1 || u > 100 || v < 1 || v > 100) {
                System.out.println("식물의 범위를 벗어난 숫자가 포함되어 있습니다.");
                return;
            }

            // 무방향 그래프 연관관계 등록 및 식물 존재 표시
            graph[u][v] = true;
            graph[v][u] = true;
            isExist[u] = true;
            isExist[v] = true;
        }

        // 4. DFS 알고리즘을 이용한 식물 그룹 수 탐색
        int dfsGroupCount = countGroupsDFS(graph, visited, isExist);

        // 5. 결과 출력 (기본 요구사항)
        System.out.println(dfsGroupCount);

        // 6. [보너스 과제] BFS 알고리즘 결과 확인
        // boolean[] bfsVisited = new boolean[101];
        // int bfsGroupCount = countGroupsBFS(graph, bfsVisited, isExist);
        // System.out.println("BFS 결과: " + bfsGroupCount);
    }

    /**
     * DFS를 이용하여 연결된 식물 그룹의 개수를 탐색합니다.
     */
    public static int countGroupsDFS(boolean[][] graph, boolean[] visited, boolean[] isExist) {
        int count = 0;

        for (int i = 1; i <= 100; i++) {
            // 존재하고 아직 방문하지 않은 식물부터 깊이 우선 탐색(DFS) 시작
            if (isExist[i] && !visited[i]) {
                dfs(graph, visited, i);
                count++; // 하나의 연결된 그룹 완성
            }
        }

        return count;
    }

    /**
     * 재귀(Recursion) 방식의 DFS 구현
     */
    public static void dfs(boolean[][] graph, boolean[] visited, int node) {
        visited[node] = true; // 현재 식물 방문 처리

        // 1번부터 100번 식물까지 순회하며 연결되어 있고 미방문한 식물 탐색
        for (int next = 1; next <= 100; next++) {
            if (graph[node][next] && !visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }

    /**
     * [보너스 과제] BFS를 이용하여 연결된 식물 그룹의 개수를 탐색합니다.
     */
    public static int countGroupsBFS(boolean[][] graph, boolean[] visited, boolean[] isExist) {
        int count = 0;

        for (int i = 1; i <= 100; i++) {
            if (isExist[i] && !visited[i]) {
                bfs(graph, visited, i);
                count++;
            }
        }

        return count;
    }

    /**
     * Queue를 이용한 BFS 구현
     */
    public static void bfs(boolean[][] graph, boolean[] visited, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next = 1; next <= 100; next++) {
                if (graph[curr][next] && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
