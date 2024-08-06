import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj12851 {
    static int n;
    static int k;
    static int min;
    static int count;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        count = 0;
        time = new int[100001];
        if (n == k) {
            System.out.println(0);
            System.out.println(1);
        } else {
            bfs(n, k);
            System.out.println(time[k] - 1);
            System.out.println(count);
        }
    }

    static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        time[n] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (time[now] > min) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                int mx = 0;
                if (i == 0) {
                    mx = now - 1;
                }
                if (i == 1) {
                    mx = now + 1;
                }
                if (i == 2) {
                    mx = now * 2;
                }

                if (mx < 0 || mx > 100000) {
                    continue;
                }

                if (mx == k) {
                    min = time[now];
                    count++;
                }

                if (time[mx] == 0 || time[mx] == time[now] + 1) {
                    time[mx] = time[now] + 1;
                    queue.add(mx);
                }
            }
        }
    }
}
