import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj11779 {
    static int n;
    static int m;
    static List<List<Node>> graph;
    static Queue<Node> queue;
    static boolean[] visit;
    static int[] distance;
    static int[] city;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        visit = new boolean[n + 1];
        distance = new int[n + 1];
        city = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
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
        }

        st = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        distance[start] = 0;

        dijkstra(start);

        writer.write(distance[end] + "\n");

        int cur = end;
        Stack<Integer> result = new Stack<>();
        while (cur != 0) {
            result.add(cur);
            cur = city[cur];
        }
        writer.write(result.size() + "\n");
        while (!result.empty()) {
            writer.write(result.pop() + " ");
        }

        writer.flush();
        writer.close();
    }

    static void dijkstra(int start) {
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int s = node.end;
            if (!visit[s]) {
                visit[s] = true;
                for (Node n : graph.get(s)) {
                    if (distance[n.end] > node.weight + n.weight) {
                        distance[n.end] = node.weight + n.weight;
                        city[n.end] = s;
                        queue.add(new Node(n.end, distance[n.end]));
                    }
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
