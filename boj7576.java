import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {
    static int m;
    static int n;
    static boolean[][] visit;
    static int[][] graph;
    static int[] x = { -1, 1, 0, 0 };
    static int[] y = { 0, 0, -1, 1 };
    static int count;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        count = 0;
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 0) {
                    count++;
                } else if (graph[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }
        if (count == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 1 && !visit[i][j]) {
                        bfs(new Point(i, j));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 0) {
                        count = 0;
                    }
                }
            }

            System.out.println(count - 1);
        }
    }

    static void bfs(Point p) {
        visit[p.x][p.y] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = point.x + x[i];
                int moveY = point.y + y[i];

                if (moveX >= 0 && moveY >= 0 && moveX < n && moveY < m) {
                    if (graph[moveX][moveY] == 0 && !visit[moveX][moveY]) {
                        queue.add(new Point(moveX, moveY));
                        count = graph[point.x][point.y] + 1;
                        graph[moveX][moveY] = count;
                        visit[moveX][moveY] = true;
                    }
                }
            }
        }

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
