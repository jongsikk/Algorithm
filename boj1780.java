import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1780 {
    static int[][] arr;
    static int[] result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(reader.readLine());
        arr = new int[n][n];
        result = new int[3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, n);

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }

    static void recur(int x, int y, int size) {
        if (check(x, y, size)) {
            if (arr[x][y] == -1) {
                result[0]++;
            } else if (arr[x][y] == 0) {
                result[1]++;
            } else {
                result[2]++;
            }
            return;
        }

        recur(x, y, size / 3);
        recur(x, y + size / 3, size / 3);
        recur(x, y + size / 3 * 2, size / 3);

        recur(x + size / 3, y, size / 3);
        recur(x + size / 3, y + size / 3, size / 3);
        recur(x + size / 3, y + size / 3 * 2, size / 3);

        recur(x + size / 3 * 2, y, size / 3);
        recur(x + size / 3 * 2, y + size / 3, size / 3);
        recur(x + size / 3 * 2, y + size / 3 * 2, size / 3);
    }

    static boolean check(int x, int y, int size) {
        int cur = arr[x][y];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[x + i][y + j] != cur) {
                    return false;
                }
            }
        }
        return true;
    }
}
