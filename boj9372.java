import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9372 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
            }
            System.out.println(n - 1);
        }
    }
}
