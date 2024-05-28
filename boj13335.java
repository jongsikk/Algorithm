import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        int count = 0;
        int weight = 0;
        while (!bridge.isEmpty()) {
            count++;
            weight -= bridge.poll();
            if (!queue.isEmpty()) {
                if (weight + queue.peek() <= l) {
                    bridge.add(queue.peek());
                    weight += queue.poll();
                } else {
                    bridge.add(0);
                }
            }
        }
        System.out.println(count);
    }
}
