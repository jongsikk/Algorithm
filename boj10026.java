import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10026 {
    static char[][] graph;
    static boolean[][] visit;
    static int n;
    static int rgCount;
    static int count;
    static int[] x = { 0, 0, -1, 1 };
    static int[] y = { -1, 1, 0, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        graph = new char[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];
        rgCount = 0;
        count = 0;
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, false);
                    count++;
                }
            }
        }
        visit = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, true);
                    rgCount++;
                }
            }
        }
        System.out.println(count + " " + rgCount);
    }

    static void dfs(int startX, int startY, boolean rg) {
        visit[startX][startY] = true;
        for (int i = 0; i < 4; i++) {
            int moveX = startX + x[i];
            int moveY = startY + y[i];
            for (int j = 0; j < n; j++) {
                if (moveX >= 0 && moveY >= 0 && !visit[moveX][moveY] && moveX < n && moveY < n) {
                    if (!rg) {
                        if (graph[startX][startY] == graph[moveX][moveY]) {
                            dfs(moveX, moveY, rg);
                        }
                    } else {
                        if ((graph[startX][startY] == 'R') || (graph[startX][startY] == 'G')) {
                            if ((graph[moveX][moveY] == 'R') || (graph[moveX][moveY] == 'G')) {
                                dfs(moveX, moveY, rg);
                            }
                        } else if (graph[startX][startY] == graph[moveX][moveY]) {
                            dfs(moveX, moveY, rg);
                        }
                    }
                }
            }
        }
    }
}
