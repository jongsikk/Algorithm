import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class boj2667 {
    static int[][] graph;
    static boolean[][] visit;
    static int total;
    static int count;
    static int n;
    static int[] x = { 0, 0, -1, 1 };
    static int[] y = { -1, 1, 0, 0 };
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }

        total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visit[i][j]) {
                    total++;
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        System.out.println(total);
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    static void dfs(int startX, int startY) {
        visit[startX][startY] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int moveX = startX + x[i];
            int moveY = startY + y[i];

            for (int j = 0; j < n; j++) {
                if (moveX >= 0 && moveY >= 0) {
                    if (graph[moveX][moveY] == 1 && !visit[moveX][moveY]) {
                        dfs(moveX, moveY);
                    }
                }
            }
        }
    }
}
