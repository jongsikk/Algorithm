import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj2667_1 {
    static int n;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    answer++;
                    int count = bfs(i, j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(answer);
        for (int i : list) {
            System.out.println(i);
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        visit[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = p[0] + dx[i];
                int my = p[1] + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < n && !visit[mx][my] && map[mx][my] == 1) {
                    visit[mx][my] = true;
                    count++;
                    queue.add(new int[] { mx, my });
                }
            }
        }
        return count;
    }
}
