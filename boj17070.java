import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17070 {
    static int n;
    static int[][] map;
    static int[] dx = { 0, -1, -1 };
    static int[] dy = { 1, 0, 1 };
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new int[n + 1][n + 1];
        answer = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 2, 0);
        System.out.println(answer);
    }

    // dir - 가로 : 0, 세로 : 1, 대각선 : 2
    static void dfs(int x, int y, int dir) {
        if (x == n && y == n) {
            answer++;
            return;
        }
        if (dir == 0 || dir == 2) {
            if (y + 1 <= n && map[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }
        }
        if (dir == 0 || dir == 1 || dir == 2) {
            if (x + 1 <= n && y + 1 <= n && map[x + 1][y + 1] == 0 && map[x + 1][y] == 0 && map[x][y + 1] == 0) {
                dfs(x + 1, y + 1, 2);
            }
        }
        if (dir == 1 || dir == 2) {
            if (x + 1 <= n && map[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }
        }
    }
}
