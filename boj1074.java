import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1074 {
    static int[][] z;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        z = new int[2][2];
        z[0][0] = 0;
        z[0][1] = 1;
        z[1][0] = 2;
        z[1][1] = 3;
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recur(r, c));
    }

    static int recur(int row, int col) {
        if (row == 0 && col == 0) {
            return 0;
        }
        return z[row % 2][col % 2] + 4 * recur(row / 2, col / 2);
        // 3 7 7
        // 77 3 + 4 * (3 + 4 *(3 + 4 * 0)) 63
        // 33 3 + 4 * (3 + 4 * 0) 15
        // 11 3 + 4 * 0 3
        // 00 0
    }
}
