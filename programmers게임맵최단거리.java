import java.util.*;

class programmers게임맵최단거리 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] visit;
    static Queue<int[]> queue;

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        visit = new int[n][m];
        queue = new LinkedList<>();

        bfs(maps);

        return visit[n - 1][m - 1] == 0 ? -1 : visit[n - 1][m - 1];
    }

    public void bfs(int[][] map) {
        visit[0][0] = 1;
        queue.add(new int[] { 0, 0 });

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                for (int j = 0; j < 4; j++) {
                    if (mx >= 0 && mx < map.length && my >= 0 && my < map[0].length) {
                        if (visit[mx][my] == 0 && map[mx][my] != 0) {
                            visit[mx][my] = visit[x][y] + 1;
                            queue.add(new int[] { mx, my });
                        }
                    }
                }
            }
        }

    }
}