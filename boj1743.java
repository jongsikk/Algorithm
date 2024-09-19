import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1743 {
    static int n;
    static int m;
    static int k;
    static int count;
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
        k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    count = 0;
                    dfs(i, j);
                    answer = Math.max(count, answer);
                }
            }
        }
        System.out.println(answer);
    }

    static void dfs(int r, int c) {
        count++;
        visit[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int mx = r + dx[i];
            int my = c + dy[i];
            if (mx > 0 && mx <= n && my > 0 && my <= m && !visit[mx][my] && map[mx][my] == 1) {
                visit[mx][my] = true;
                dfs(mx, my);
            }
        }
    }
}
