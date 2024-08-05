import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697 {
    static int n;
    static int k;
    static int answer;
    static boolean[] visit;
    static int[] dx = { -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        if (n == k) {
            System.out.println(0);
        } else {
            System.out.println(bfs(n, k));
        }
    }

    static int bfs(int n, int k) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(n, 0));
        visit[n] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x == k) {
                return now.time;
            }
            for (int i = 0; i < 3; i++) {
                Point mx = null;
                if (i == 2) {
                    if (now.x * 2 > -1 && now.x * 2 <= 100000 && !visit[now.x * 2]) {
                        mx = new Point(now.x * 2, now.time + 1);
                        visit[mx.x] = true;
                        queue.add(mx);
                    }
                } else {
                    if (now.x + dx[i] > -1 && now.x + dx[i] <= 100000 && !visit[now.x + dx[i]]) {
                        mx = new Point(now.x + dx[i], now.time + 1);
                        visit[mx.x] = true;
                        queue.add(mx);
                    }
                }
            }
        }
        return 0;
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
