import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1927 {
    static PriorityQueue<Integer> queue;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(reader.readLine());

            if (x == 0) {
                if (queue.size() == 0) {
                    x = 0;
                } else {
                    x = queue.poll();
                }
                System.out.println(x);
            } else {
                queue.add(x);
            }
        }
    }
}
