import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1916_1 {
    static int n;
    static int m;
    static boolean[] visit;
    static int[] distance;
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        distance = new int[n + 1];
        visit = new boolean[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(distance[end]);
    }

    static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        distance[start] = 0;
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!visit[node.end]) {
                visit[node.end] = true;
                for (Node n : graph.get(node.end)) {
                    if (distance[n.end] > n.cost + distance[node.end]) {
                        distance[n.end] = n.cost + distance[node.end];
                        queue.add(new Node(n.end, distance[n.end]));
                    }
                }
            }
        }
    }

    static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
