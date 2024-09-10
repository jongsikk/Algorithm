import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3085 {
    static int n;
    static char[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = dx[k] + i;
                    int y = dy[k] + j;
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        char temp = map[i][j];
                        map[i][j] = map[x][y];
                        map[x][y] = temp;
                        answer = Math.max(answer, check());
                        map[x][y] = map[i][j];
                        map[i][j] = temp;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static int check() {
        int rcount = 1;
        int ccount = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            rcount = 1;
            ccount = 1;
            for (int j = 1; j < n; j++) {
                if (map[i][j] == map[i][j - 1]) {
                    rcount++;
                    max = Math.max(rcount, max);
                } else {
                    rcount = 1;
                }
            }
            for (int j = 1; j < n; j++) {
                if (map[j][i] == map[j - 1][i]) {
                    ccount++;
                    max = Math.max(max, ccount);
                } else {
                    ccount = 1;
                }
            }
        }
        return max;
    }
}
