import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5972 {
    static int n;
    static int m;
    static boolean[] visit;
    static int[] distance;
    static Queue<Node> queue;
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        visit = new boolean[n + 1];
        graph = new ArrayList<>();
        queue = new PriorityQueue<>((n1, n2) -> (n1.weight - n2.weight));
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }
        distance[1] = 0;
        dijkstra(1);

        System.out.println(distance[n]);
    }

    static void dijkstra(int start) {
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int s = node.end;
            if (!visit[s]) {
                visit[s] = true;
                for (Node n : graph.get(s)) {
                    distance[n.end] = Math.min(distance[n.end], distance[s] + n.weight);
                    queue.add(new Node(n.end, distance[n.end]));
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
