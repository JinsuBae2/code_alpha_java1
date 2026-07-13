package course2;

import java.util.Queue;
import java.util.LinkedList;

public class RoadToBiodome09 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 없습니다.");
            return;
        }

        // 공백으로 이루어진 단일 인수가 들어온 경우 분리 처리
        if (args.length == 1 && args[0].contains(" ")) {
            args = args[0].trim().split("\\s+");
        }

        int n = args.length;
        int m = args[0].length();

        // 2차원 배열 유효성 및 문자 검증
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (args[i].length() != m) {
                System.out.println("2차원 배열이 아닙니다. (각 행의 길이가 다릅니다)");
                return;
            }
            for (int j = 0; j < m; j++) {
                char ch = args[i].charAt(j);
                if (ch != '0' && ch != '1' && ch != '2') {
                    System.out.println("입력값에 0, 1, 2 이외의 문자가 포함되어 있습니다.");
                    return;
                }
                grid[i][j] = ch - '0';
            }
        }

        // BFS 알고리즘을 사용한 최단 경로 탐색
        int result = findShortestPath(grid);

        if (result == -1) {
            System.out.println("입구에서 출구로 연결된 안전한 경로가 없습니다.");
        } else {
            System.out.println(result);
        }
    }

    public static int findShortestPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // 시작점(0,0)이나 끝점(n-1, m-1)이 이동할 수 없는 곳(1이 아닌 곳)이면 경로 없음
        if (grid[0][0] != 1 || grid[n - 1][m - 1] != 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // 큐 저장 형태: {행, 열, 거리(이동 횟수)}
        queue.offer(new int[] { 0, 0, 0 });
        visited[0][0] = true;

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            // 출구에 도달한 경우 최단 거리 반환
            if (r == n - 1 && c == m - 1) {
                return dist;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // 범위 내에 있고, 이동 가능한 구역(1)이며, 방문하지 않은 경우
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[] { nr, nc, dist + 1 });
                    }
                }
            }
        }

        return -1;
    }
}
