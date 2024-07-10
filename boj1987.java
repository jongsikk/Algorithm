import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1987 {
    static int r;
    static int c;
    static int answer;
    static int[][] board;
    static boolean[] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        answer = 0;
        board = new int[r][c];
        visit = new boolean[100];

        for (int i = 0; i < r; i++) {
            String line = reader.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int count) {
        visit[board[x][y]] = true;

        if (check(x, y)) {
            answer = Math.max(answer, count);
        }

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && my >= 0 && mx < r && my < c && !visit[board[mx][my]]) {
                visit[board[mx][my]] = true;
                dfs(mx, my, count + 1);
                visit[board[mx][my]] = false;
            }
        }
    }

    static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && my >= 0 && mx < r && my < c && !visit[board[mx][my]]) {
                return false;
            }
        }
        return true;
    }
}
