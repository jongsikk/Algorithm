import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1197 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            parent[i] = i;
        }
        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            queue.add(new Node(start, end, weight));
        }
        int answer = 0;

        for (int i = 0; i < e; i++) {
            Node node = queue.poll();
            int parent1 = checkParent(node.start);
            int parent2 = checkParent(node.end);
            if (parent1 != parent2) {
                answer += node.weight;
                if (parent1 > parent2) {
                    parent[parent1] = parent2;
                } else {
                    parent[parent2] = parent1;
                }
            }
        }
        System.out.println(answer);
    }

    static int checkParent(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = checkParent(parent[v]);
    }

    static class Node {
        int start;
        int end;
        int weight;

        Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
