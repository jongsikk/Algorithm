import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1238 {
    static int n;
    static int m;
    static int x;
    static List<List<Node>> graph;
    static Queue<Node> queue;
    static boolean[] visit;
    static int[] distance;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        queue = new PriorityQueue<>((n1, n2) -> {
            return n1.weight - n2.weight;
        });
        visit = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        sum = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        for (int i = 1; i <= n; i++) {
            if (i != x) {
                distance[i] = 0;
                dijkstra(i);
                sum[i] += distance[x];
                Arrays.fill(distance, Integer.MAX_VALUE);
                visit = new boolean[n + 1];
            }
        }
        distance[x] = 0;
        dijkstra(x);
        for (int i = 1; i <= n; i++) {
            if (i != x) {
                sum[i] += distance[i];
            }
        }
        System.out.println(Arrays.stream(sum).max().getAsInt());
    }

    static void dijkstra(int start) {
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int s = node.end;
            if (!visit[s]) {
                visit[s] = true;
                for (int i = 0; i < graph.get(s).size(); i++) {
                    distance[graph.get(s).get(i).end] = Math.min(graph.get(s).get(i).weight + node.weight,
                            distance[graph.get(s).get(i).end]);
                    queue.add(new Node(graph.get(s).get(i).end, distance[graph.get(s).get(i).end]));
                }
            }
        }
    }

    static class Node {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
