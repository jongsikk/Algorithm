import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10431 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int t = Integer.parseInt(st.nextToken());
            int count = 0;
            int[] arr = new int[20];
            for (int j = 0; j < 20; j++) {
                int k = Integer.parseInt(st.nextToken());
                arr[j] = k;
            }
            for (int j = 1; j < 20; j++) {
                for (int k = j - 1; k >= 0; k--) {
                    if (arr[j] < arr[k]) {
                        count++;
                    }
                }
            }
            System.out.println(t + " " + count);
        }
    }
}
