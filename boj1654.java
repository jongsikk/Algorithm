import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        long max = Arrays.stream(arr).max().getAsInt() + 1L;
        long min = 0;
        if (n == 1) {
            System.out.println(arr[0]);
        } else {
            while (min < max) {
                long mid = (min + max) / 2;
                int count = 0;
                for (int i = 0; i < k; i++) {
                    count += arr[i] / mid;
                }
                if (count < n) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            System.out.println(min - 1);
        }
    }
}
