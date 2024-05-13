import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj10994 {
    static char[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int length = (n - 1) * 4 + 1;
        map = new char[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                map[i][j] = ' ';
            }
        }

        recur(0, 0, n);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void recur(int x, int y, int n) {
        if (n == 0) {
            return;
        }
        int length = (n - 1) * 4 + 1;
        for (int i = x; i < x + length; i++) {
            map[x][i] = '*';
            map[i][y] = '*';
            map[i][length - 1 + x] = '*';
            map[length - 1 + x][i] = '*';
        }
        recur(x + 2, y + 2, n - 1);
    }
}
