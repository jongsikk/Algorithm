import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj18352 {
    static List<List<Integer>> graph;
    static int[] distance;
    static int n;
    static int m;
    static int k;
    static int x;
    static int count;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        queue = new PriorityQueue<>();
        count = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        distance[x] = 0;
        dijkstra(x);
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(-1);
        }
    }

    static void dijkstra(int start) {
        queue.add(start);
        while (!queue.isEmpty()) {
            int s = queue.poll();
            for (int i = 0; i < graph.get(s).size(); i++) {
                int dist = distance[s] + 1;
                if (dist < distance[graph.get(s).get(i)]) {
                    distance[graph.get(s).get(i)] = dist;
                    queue.add(graph.get(s).get(i));
                }
            }
        }
    }

}
