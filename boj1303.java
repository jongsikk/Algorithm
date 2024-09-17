import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1303 {
    static int n;
    static int m;
    static int wSum;
    static int wCount;
    static int bSum;
    static int bCount;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        m = Integer.parseInt(line.split(" ")[0]);
        n = Integer.parseInt(line.split(" ")[1]);
        map = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            line = reader.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'W' && !visit[i][j]) {
                    wCount = 1;
                    dfs(i, j, 'W');
                    wSum += wCount * wCount;
                } else if (map[i][j] == 'B' && !visit[i][j]) {
                    bCount = 1;
                    dfs(i, j, 'B');
                    bSum += bCount * bCount;
                }
            }
        }
        System.out.println(wSum + " " + bSum);
    }

    static void dfs(int x, int y, char color) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && mx < n && my >= 0 && my < m && !visit[mx][my] && map[mx][my] == color) {
                visit[mx][my] = true;
                if (color == 'W') {
                    wCount++;
                } else {
                    bCount++;
                }
                dfs(mx, my, color);
            }
        }
    }
}
