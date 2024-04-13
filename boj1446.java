import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj1446 {
    static int n;
    static int d;
    static List<List<Node>> graph;
    static int[] dist;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < 10001; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if (end - start > distance && end <= d) {
                graph.get(start).add(new Node(start, end, distance));
            }
        }
        index = 0;
        dist[0] = 0;
        dijkstra();
        System.out.println(dist[d]);
    }

    static void dijkstra() {
        while (index < d) {
            dist[index + 1] = Math.min(dist[index + 1], dist[index] + 1);
            for (int i = 0; i < graph.get(index).size(); i++) {
                dist[graph.get(index).get(i).end] = Math.min(dist[graph.get(index).get(i).end],
                        dist[index] + graph.get(index).get(i).distance);
            }
            index++;
        }
    }

    static class Node {
        int end;
        int distance;

        Node(int start, int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}
