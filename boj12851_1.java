import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj12851_1 {
    static int n;
    static int k;
    static int count;
    static int answer;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = 0;
        answer = Integer.MAX_VALUE;
        time = new int[100001];
        if (n == k) {
            System.out.println(0);
            System.out.println(1);
        } else {
            bfs(n);
            System.out.println(answer);
            System.out.println(count);
        }
    }

    static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        time[n] = 1;
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (time[start] > answer) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                int m = start;
                if (i == 0) {
                    m -= 1;
                }
                if (i == 1) {
                    m += 1;
                }
                if (i == 2) {
                    m *= 2;
                }
                if (m < 0 || m > 100000 || (time[m] != 0 && time[m] < time[start] + 1)) {
                    continue;
                }
                if (m == k) {
                    answer = time[start];
                    count++;
                }
                time[m] = time[start] + 1;
                queue.add(m);
            }
        }
    }
}
