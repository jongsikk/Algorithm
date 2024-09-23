import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13549_1 {
    static int n;
    static int k;
    static int answer;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        time = new int[100001];

        if (n >= k) {
            System.out.println(n - k);
        } else {
            bfs(n);
            System.out.println(time[k] - 1);
        }

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        time[start] = 1;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (time[x] > answer) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                int mx = x;
                if (i == 0) {
                    mx -= 1;
                }
                if (i == 1) {
                    mx += 1;
                }
                if (i == 2) {
                    mx *= 2;
                }
                if (mx < 0 || mx > 100000) {
                    continue;
                }
                if (i == 0 || i == 1) {
                    if (time[mx] == 0 || time[mx] > time[x] + 1) {
                        queue.add(mx);
                        time[mx] = time[x] + 1;
                    }
                } else {
                    if (time[mx] == 0 || time[mx] > time[x]) {
                        queue.add(mx);
                        time[mx] = time[x];
                    }
                }
            }
        }
    }
}
