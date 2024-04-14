import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1916 {
    static int n;
    static int m;
    static Queue<Node> queue;
    static List<List<Node>> graph;
    static int[] weight;
    static boolean[] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        queue = new PriorityQueue<>((n1, n2) -> {
            return n1.weight - n2.weight;
        });
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        graph = new ArrayList<>();
        weight = new int[n + 1];
        visit = new boolean[n + 1];

        Arrays.fill(weight, Integer.MAX_VALUE);

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

        weight[start] = 0;
        dijkstra(start);

        writer.write(weight[end] + "");
        writer.flush();
        writer.close();
    }

    static void dijkstra(int start) {
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int e = n.end;
            if (!visit[e]) {
                visit[e] = true;
                for (int i = 0; i < graph.get(e).size(); i++) {
                    int w = weight[e] + graph.get(e).get(i).weight;
                    weight[graph.get(e).get(i).end] = Math.min(weight[graph.get(e).get(i).end], w);
                    queue.add(new Node(graph.get(e).get(i).end, weight[graph.get(e).get(i).end]));
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
