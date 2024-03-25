import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1012 {
    static int t;
    static int n;
    static int m;
    static int k;
    static int[][] graph;
    static boolean[][] visit;
    static int count;
    static int[] x = { 0, 0, -1, 1 };
    static int[] y = { -1, 1, 0, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            graph = new int[m + 1][n + 1];
            visit = new boolean[m + 1][n + 1];
            count = 0;
            for (int j = 0; j < k; j++) {
                String[] line = reader.readLine().split(" ");
                int v1 = Integer.parseInt(line[0]);
                int v2 = Integer.parseInt(line[1]);

                graph[v1][v2] = 1;
            }

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (graph[j][k] == 1 && !visit[j][k]) {
                        count++;
                        dfs(j, k);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int startX, int startY) {
        visit[startX][startY] = true;
        for (int i = 0; i < 4; i++) {
            int moveX = startX + x[i];
            int moveY = startY + y[i];
            if (moveX >= 0 && moveY >= 0 && moveX < m && moveY < n) {
                if (graph[moveX][moveY] == 1 && !visit[moveX][moveY]) {
                    dfs(moveX, moveY);
                }
            }
        }
    }
}
