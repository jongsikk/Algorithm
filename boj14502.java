import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502 {
    static int n;
    static int m;
    static int[][] graph;
    static boolean[][] visit;
    static int wallCount;
    static int wall;
    static int count;
    static int result;
    static int[] x = { -1, 1, 0, 0 };
    static int[] y = { 0, 0, -1, 1 };
    static Queue<Point> queue;
    static List<Point> virusList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][m + 1];
        visit = new boolean[n][m];
        virusList = new ArrayList<>();
        wallCount = 0;
        wall = 0;
        count = 0;
        result = 0;
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
                if (graph[i][j] == 1) {
                    wall++;
                }
            }
        }
        selectWall();
        System.out.println(result);
    }

    static void selectWall() {
        if (wallCount == 3) {
            bfs();
            count = 0;
            visit = new boolean[n][m];
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    wallCount++;
                    selectWall();
                    graph[i][j] = 0;
                    wallCount--;
                }
            }
        }
    }

    static void bfs() {
        for (int k = 0; k < virusList.size(); k++) {
            Point point = virusList.get(k);
            queue.add(point);
            count++;
            while (!queue.isEmpty()) {
                point = queue.poll();
                visit[point.x][point.y] = true;
                for (int i = 0; i < 4; i++) {
                    int moveX = point.x + x[i];
                    int moveY = point.y + y[i];
                    if (moveX >= 0 && moveY >= 0 && graph[moveX][moveY] == 0 && moveX < n
                            && moveY < m
                            && !visit[moveX][moveY]) {
                        queue.add(new Point(moveX, moveY));
                        visit[moveX][moveY] = true;
                        count++;
                    }
                }
            }
        }
        result = Math.max(result, n * m - count - wall - wallCount);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
