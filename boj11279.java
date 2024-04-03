import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj11279 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(reader.readLine());
            if (m == 0) {
                if (queue.size() == 0) {
                    m = 0;
                } else {
                    m = queue.poll();
                }
                System.out.println(m);
            } else {
                queue.add(m);
            }
        }
    }
}
