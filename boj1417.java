import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj1417 {
    static PriorityQueue<Integer> queue;
    static int dasom;
    static int n;
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        dasom = Integer.parseInt(reader.readLine());
        queue = new PriorityQueue<>(Collections.reverseOrder());
        if (n == 1) {
            count = 0;
        } else {
            for (int i = 0; i < n - 1; i++) {
                queue.add(Integer.parseInt(reader.readLine()));
            }
            while (true) {
                n = queue.poll();
                if (dasom <= n) {
                    dasom++;
                    queue.add(--n);
                    count++;
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
