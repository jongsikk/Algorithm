import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17086 {
    static int n;
    static int m;
    static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static int[][] map;
    static int[][] dist;
    static boolean[][] visit;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        bfs();

        int answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, dist[i][j]);
            }
        }

        System.out.println(answer);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int mx = p[0] + dx[i];
                int my = p[1] + dy[i];
                if (mx < 0 || mx >= n || my < 0 || my >= m || map[mx][my] == 1) {
                    continue;
                }
                if (dist[mx][my] == 0) {
                    dist[mx][my] = dist[p[0]][p[1]] + 1;
                    queue.add(new int[] { mx, my, dist[mx][my] });
                }
            }
        }
    }
}
