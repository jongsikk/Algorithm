import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2606 {
    static int n;
    static int m;
    static int[][] graph;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        count = 0;
        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        dfs(1);
        System.out.println(count);
    }

    static void dfs(int start) {
        visit[start] = true;
        for (int i = 0; i <= n; i++) {
            if (graph[start][i] == 1 && !visit[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
