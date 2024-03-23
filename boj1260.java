import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1260 {
    static int[][] graph;
    static boolean[] visit;
    static Queue<Integer> queue;
    static int n;
    static int m;
    static int v;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        v = Integer.parseInt(line[2]);
        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            line = reader.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        dfs(v);

        visit = new boolean[n + 1];
        System.out.println();
        bfs(v);
    }

    static void dfs(int start) {
        visit[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i <= n; i++) {
            if (graph[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        visit[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + " ");
            for (int i = 0; i <= n; i++) {
                if (graph[start][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
