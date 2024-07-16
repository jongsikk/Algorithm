import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2448 {
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        map = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                map[i][j] = ' ';
            }
        }
        recur(0, n - 1, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                writer.write(map[i][j]);
            }
            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }

    static void recur(int x, int y, int n) {
        if (n == 3) {
            map[x][y] = '*';
            map[x + 1][y - 1] = '*';
            map[x + 1][y + 1] = '*';
            map[x + 2][y - 2] = '*';
            map[x + 2][y - 1] = '*';
            map[x + 2][y] = '*';
            map[x + 2][y + 1] = '*';
            map[x + 2][y + 2] = '*';
            return;
        } else {
            recur(x, y, n / 2);
            recur(x + n / 2, y - (n / 2), n / 2);
            recur(x + n / 2, y + (n / 2), n / 2);
        }
    }
}
