import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj1655 {
    static Queue<Integer> queue;
    static Queue<Integer> queue2;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        queue = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        queue2 = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(reader.readLine());
            if (i % 2 == 0) {
                queue.add(m);
            } else {
                queue2.add(m);
            }
            if (!queue.isEmpty() && !queue2.isEmpty() && queue.peek() > queue2.peek()) {
                int n1 = queue.poll();
                int n2 = queue2.poll();
                queue.add(n2);
                queue2.add(n1);
            }
            writer.write(queue.peek() + "\n");
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
