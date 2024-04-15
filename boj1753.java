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
import java.util.StringTokenizer;

public class boj1753 {
    static int v;
    static int e;
    static int start;
    static List<List<Node>> graph;
    static int[] distance;
    static boolean[] visit;
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        distance = new int[v + 1];
        visit = new boolean[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        queue = new PriorityQueue<>((n1, n2) -> {
            return n1.w - n2.w;
        });

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        start = Integer.parseInt(reader.readLine());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }
        distance[start] = 0;
        dijkstra(start);
        for (int i = 1; i <= v; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                writer.write("INF" + "\n");
            } else {
                writer.write(distance[i] + "\n");
            }
        }
        writer.flush();
        writer.close();
    }

    static void dijkstra(int start) {
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int s = node.v;
            if (!visit[s]) {
                visit[s] = true;
                for (int i = 0; i < graph.get(s).size(); i++) {
                    distance[graph.get(s).get(i).v] = Math.min(graph.get(s).get(i).w + distance[s],
                            distance[graph.get(s).get(i).v]);
                    queue.add(new Node(graph.get(s).get(i).v, distance[graph.get(s).get(i).v]));
                }
            }
        }
    }

    static class Node {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
