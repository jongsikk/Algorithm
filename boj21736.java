import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21736 {
    static int n;
    static int m;
    static int answer;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];
        answer = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'I') {
                    x = i;
                    y = j;
                }
                map[i][j] = line.charAt(j);
            }
        }
        dfs(x, y);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx > -1 && my > -1 && mx < n && my < m && map[mx][my] != 'X' && !visit[mx][my]) {
                if (map[mx][my] == 'P') {
                    answer++;
                }
                visit[mx][my] = true;
                dfs(mx, my);
            }
        }
    }
}
