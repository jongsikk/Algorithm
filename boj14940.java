import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14940 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        distance = new int[n][m];
        visit = new boolean[n][m];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                distance[i][j] = Integer.MAX_VALUE;
                if (num == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x, y, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && distance[i][j] == Integer.MAX_VALUE) {
                    writer.write(-1 + " ");
                } else if (map[i][j] == 0) {
                    writer.write(0 + " ");
                } else {
                    writer.write(distance[i][j] + " ");
                }
            }
            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }

    static void bfs(int x, int y, int count) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, count));
        distance[x][y] = count;
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            distance[p.x][p.y] = p.count;
            for (int i = 0; i < 4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];
                int mcount = p.count + 1;
                if (mx > -1 && mx < n && my > -1 && my < m && !visit[mx][my] && distance[mx][my] == Integer.MAX_VALUE
                        && map[mx][my] != 0) {
                    visit[mx][my] = true;
                    queue.add(new Point(mx, my, mcount));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
