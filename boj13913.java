import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj13913 {
    static int time;
    static int[] route;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        time = Integer.MAX_VALUE;
        route = new int[100001];
        visit = new boolean[100001];
        bfs(n, k);
        System.out.println(time);
        Stack<Integer> stack = new Stack<>();
        int a = k;
        while (a != n) {
            stack.add(a);
            a = route[a];
        }
        stack.add(n);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void bfs(int n, int k) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(n, 0));
        visit[n] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x == k) {
                time = Math.min(now.time, time);
                return;
            }
            for (int i = 0; i < 3; i++) {
                int mx = now.x;
                int mt = now.time + 1;
                if (i == 0) {
                    mx -= 1;
                }
                if (i == 1) {
                    mx += 1;
                }
                if (i == 2) {
                    mx *= 2;
                }
                if (mx < 0 || mx > 100000 || visit[mx]) {
                    continue;
                }
                visit[mx] = true;
                route[mx] = now.x;
                queue.add(new Point(mx, mt));
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
