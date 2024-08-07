import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13549 {
    static int n;
    static int k;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        bfs(n, k);

        System.out.println(min);
    }

    static void bfs(int n, int k) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(n, 0));
        visit[n] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            visit[now.x] = true;
            if (now.x == k) {
                min = Math.min(min, now.time);
            }
            for (int i = 0; i < 3; i++) {
                int mx = now.x;
                int time = now.time;
                if (i == 0) {
                    mx = mx * 2;
                }
                if (i == 1) {
                    mx = mx - 1;
                    time = time + 1;
                }
                if (i == 2) {
                    mx = mx + 1;
                    time = time + 1;
                }
                if (mx < 0 || mx > 100000 || visit[mx]) {
                    continue;
                }
                visit[mx] = true;
                queue.add(new Point(mx, time));
            }
        }
    }

    static class Point {
        int x;
        int time;

        Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
