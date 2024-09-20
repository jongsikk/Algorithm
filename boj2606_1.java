import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2606_1 {
    static int n;
    static int c;
    static int answer;
    static int[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());
        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        StringTokenizer st;
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        answer = 0;
        dfs(1);
        System.out.println(answer);
    }

    static void dfs(int start) {
        visit[start] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[start][i] == 1 && !visit[i]) {
                answer++;
                dfs(i);
            }
        }
    }
}
