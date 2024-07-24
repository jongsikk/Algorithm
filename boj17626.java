import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj17626 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] num = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = num[i - 1] + 1;
            for (int j = 1; j * j <= i; j++) {
                num[i] = Math.min(num[i], num[i - j * j] + 1);
            }
        }
        System.out.println(num[n]);
    }
}
