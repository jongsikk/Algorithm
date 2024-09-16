import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260_1 {
    static int n;
    static int m;
    static int v;
    static boolean[] visit;
    static int[][] graph;
    static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        dfs(v);
        writer.write("\n");
        visit = new boolean[n + 1];
        bfs(v);
        writer.flush();
        writer.close();
    }

    static void dfs(int start) throws IOException {
        visit[start] = true;
        writer.write(start + " ");
        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] != 0 && !visit[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            writer.write(num + " ");
            for (int i = 0; i < graph[start].length; i++) {
                if (graph[num][i] != 0 && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
