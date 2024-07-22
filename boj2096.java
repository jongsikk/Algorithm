import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2096 {
    static int n;
    static int[][] map;
    static int[][] max;
    static int[][] min;
    static int[] dx = { 1, 1, 1 };
    static int[] dy = { -1, 0, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][3];
        max = new int[n][3];
        min = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max[i][j] = map[i][j];
                if (i == 0)
                    min[i][j] = map[i][j];
                else
                    min[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < n && y < 3 && y > -1) {
                        max[x][y] = Math.max(max[i][j] + map[x][y], max[x][y]);
                        min[x][y] = Math.min(min[i][j] + map[x][y], min[x][y]);
                    }
                }
            }
        }

        System.out
                .println(Arrays.stream(max[n - 1]).max().getAsInt() + " " + Arrays.stream(min[n - 1]).min().getAsInt());
    }
}
