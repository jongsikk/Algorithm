import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2580 {
    static int[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        input = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 9; j++) {
                input[i][j] = Integer.parseInt((st.nextToken()));
            }
        }

        dfs(0, 0);
    }

    static void dfs(int col, int row) {
        if (row == 9) {
            dfs(col + 1, 0);
            return;
        }

        if (col == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(input[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (input[col][row] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(col, row, i)) {
                    input[col][row] = i;
                    dfs(col, row + 1);
                }
            }
            input[col][row] = 0;
            return;
        }

        dfs(col, row + 1);
    }

    static boolean check(int col, int row, int num) {
        for (int i = 0; i < 9; i++) {
            if (num == input[col][i]) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (num == input[i][row]) {
                return false;
            }
        }

        int x = col / 3 * 3;
        int y = row / 3 * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (input[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

}
