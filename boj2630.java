import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2630 {
    static int n;
    static int blue;
    static int white;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        blue = 0;
        white = 0;
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paper(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    static void paper(int n, int x, int y) {
        if (check(n, x, y)) {
            if (map[x][y] == 0)
                white++;
            else
                blue++;
            return;
        }
        paper(n / 2, x, y);
        paper(n / 2, x, y + n / 2);
        paper(n / 2, x + n / 2, y);
        paper(n / 2, x + n / 2, y + n / 2);
    }

    static boolean check(int n, int x, int y) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[i][j] != map[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
