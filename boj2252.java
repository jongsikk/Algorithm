import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2252 {
    static int n;
    static int m;
    static int[] degree;
    static boolean[] visit;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        degree = new int[n + 1];
        visit = new boolean[n + 1];
        graph = new ArrayList<>();
        int[] answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            degree[b]++;
            graph.get(a).add(b);
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == 0) {
                visit[i] = true;
                queue.add(i);
            }
        }
        for (int i = 1; i < n + 1; i++) {
            int v = queue.poll();
            System.out.println(v);
            answer[i] = v;
            for (int integer : graph.get(v)) {
                degree[integer]--;
            }
            for (int j = 1; j < n + 1; j++) {
                if (degree[j] == 0 && !visit[j]) {
                    visit[j] = true;
                    queue.add(j);
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            System.out.print(answer[i] + " ");
        }
    }

}
