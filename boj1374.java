import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1374 {
    static int n;
    static PriorityQueue<Integer> queue;
    static Time[] times;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(reader.readLine());
        times = new Time[n];
        queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            st.nextToken();
            times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(times, (t1, t2) -> {
            return t1.start == t2.start ? t1.end - t2.end : t1.start - t2.start;
        });

        for (int i = 0; i < n; i++) {
            queue.add(times[i].end);
            if (queue.peek() <= times[i].start) {
                queue.poll();
            }
        }

        System.out.println(queue.size());
    }

    static class Time {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
