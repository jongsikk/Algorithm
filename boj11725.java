import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj11725 {
    static List<List<Integer>> graph;
    static int[] result;
    static boolean[] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        result = new int[n + 1];
        visit = new boolean[n + 1];
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1);
        for (int i = 2; i < n + 1; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int start) {
        visit[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!visit[graph.get(start).get(i)]) {
                result[graph.get(start).get(i)] = start;
                dfs(graph.get(start).get(i));
            }
        }
    }
}
