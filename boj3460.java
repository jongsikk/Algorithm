import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3460 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                sb.append(n % 2);
                n /= 2;
            }
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == '1') {
                    System.out.print(j + " ");
                }
            }
        }
    }
}
