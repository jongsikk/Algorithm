import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178 {
    static int n;
    static int m;
    static int[][] graph;
    static int[][] distance;
    static boolean[][] visit;
    static int count;
    static int[] x = { 0, 0, -1, 1 };
    static int[] y = { -1, 1, 0, 0 };
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visit = new boolean[n][m];
        distance = new int[n][m];
        queue = new LinkedList<>();
        count = 0;
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }
        bfs(new Point(0, 0, 1));
        System.out.println(distance[n - 1][m - 1] + 1);
    }

    static void bfs(Point point) {
        visit[point.x][point.y] = true;
        distance[point.x][point.y] = point.distance;
        queue.add(point);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            count = p.distance;
            for (int i = 0; i < 4; i++) {
                int moveX = p.x + x[i];
                int moveY = p.y + y[i];
                if (moveX >= 0 && moveY >= 0 && moveX < n && moveY < m && graph[moveX][moveY] == 1
                        && !visit[moveX][moveY]) {
                    queue.add(new Point(moveX, moveY, count + 1));
                    distance[moveX][moveY] = count;
                    visit[moveX][moveY] = true;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
