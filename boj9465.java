import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] sticker = new int[2][n];
            StringTokenizer st;
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(reader.readLine());
                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] sum = new int[2][n + 1];
            sum[0][1] = sticker[0][0];
            sum[1][1] = sticker[1][0];
            for (int j = 2; j <= n; j++) {
                sum[0][j] = Math.max(sum[1][j - 1], sum[1][j - 2]) + sticker[0][j - 1];
                sum[1][j] = Math.max(sum[0][j - 1], sum[0][j - 2]) + sticker[1][j - 1];
            }
            System.out.println(Math.max(sum[0][n], sum[1][n]));
        }
    }
}
