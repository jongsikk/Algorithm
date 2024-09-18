import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178_1 {
    static int n;
    static int m;
    static int answer;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = Integer.parseInt(line.charAt(j) + "");
            }
        }
        bfs(1, 1, 1);
        System.out.println(answer);
    }

    static void bfs(int x, int y, int count) {
        visit[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y, count });
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] == n && p[1] == m) {
                answer = Math.max(answer, p[2]);
            }
            for (int i = 0; i < 4; i++) {
                int mx = p[0] + dx[i];
                int my = p[1] + dy[i];
                if (mx > 0 && mx <= n && my > 0 && my <= m && !visit[mx][my] && map[mx][my] == 1) {
                    queue.add(new int[] { mx, my, p[2] + 1 });
                    visit[mx][my] = true;
                }
            }
        }
    }
}
