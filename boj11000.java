import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj11000 {
    static int n;
    static Time[] times;
    static PriorityQueue<Integer> queue;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        queue = new PriorityQueue<>();
        n = Integer.parseInt(reader.readLine());
        times = new Time[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            times[i] = new Time(s, t);
        }
        Arrays.sort(times, (t1, t2) -> {
            if (t1.s == t2.s) {
                return t1.t - t2.t;
            }
            return t1.s - t2.s;
        });

        queue.add(times[0].t);

        for (int i = 1; i < n; i++) {
            if (times[i].s >= queue.peek()) {
                queue.poll();
            }
            queue.add(times[i].t);
        }

        System.out.println(queue.size());
    }

    static class Time {
        int s;
        int t;

        public Time(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}
