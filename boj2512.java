import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2512 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(reader.readLine());

        int min = 0;
        int max = Arrays.stream(arr).max().getAsInt();
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }
            if (sum <= m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(min - 1);

    }
}
