import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1010 {
    static int[][] memo;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(reader.readLine());
        memo = new int[30][30];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            writer.write(bridge(m, n) + "\n");
        }
        writer.flush();
        writer.close();
    }

    static int bridge(int n, int m) {
        if (n == m || m == 0) {
            return 1;
        }
        if (memo[n][m] > 0) {
            return memo[n][m];
        }
        return memo[n][m] = bridge(n - 1, m - 1) + bridge(n - 1, m);
    }
}
