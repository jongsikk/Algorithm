import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1890 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] board = new int[n][n];
        long[][] count = new long[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] != 0 && !(i == n - 1 && j == n - 1)) {
                    int jump = board[i][j];
                    if (jump + i < n) {
                        count[i + jump][j] = count[i][j] + count[i + jump][j];
                    }
                    if (jump + j < n) {
                        count[i][j + jump] = count[i][j] + count[i][j + jump];
                    }
                }
            }
        }

        System.out.println(count[n - 1][n - 1]);
    }
}
