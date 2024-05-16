import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2447 {
    static char[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = ' ';
            }
        }

        recur(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                writer.write(map[i][j] + "");
            }
            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }

    static void recur(int x, int y, int n) {
        if (n == 1) {
            map[x][y] = '*';
            return;
        }
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                if (count != 5) {
                    recur(x + i * n / 3, y + j * n / 3, n / 3);
                }
            }
        }

    }
}
