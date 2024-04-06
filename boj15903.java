import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj15903 {
    static PriorityQueue<Long> queue;
    static long n;
    static long m;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        queue = new PriorityQueue<>();
        st = new StringTokenizer(reader.readLine());
        sum = 0;

        for (long i = 0; i < n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (long i = 0; i < m; i++) {
            long n1 = queue.poll();
            long n2 = queue.poll();
            for (long j = 0; j < 2; j++) {
                queue.add(n1 + n2);
            }
        }

        while (!queue.isEmpty()) {
            sum += queue.poll();
        }

        System.out.println(sum);
    }
}
