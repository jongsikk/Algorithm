import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj11286 {
    static int n;
    static int m;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        queue = new PriorityQueue<>((i1, i2) -> {
            int n1 = Math.abs(i1);
            int n2 = Math.abs(i2);

            if (n1 == n2) {
                return i1 > i2 ? 1 : -1;
            } else {
                return n1 - n2;
            }
        });

        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(reader.readLine());
            if (m == 0) {
                if (queue.size() == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(m);
            }
        }
    }
}
