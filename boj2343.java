import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Arrays.stream(arr).max().getAsInt();
        int max = Arrays.stream(arr).sum();
        if (n == m) {
            System.out.println(Arrays.stream(arr).max().getAsInt());
        } else {
            int result = 0;
            while (min <= max) {
                int mid = (min + max) / 2;
                int sum = 0;
                int count = 1;
                for (int i = 0; i < n; i++) {
                    if (sum + arr[i] > mid) {
                        count++;
                        sum = 0;
                    }
                    sum += arr[i];
                }
                if (count <= m) {
                    max = mid - 1;
                    result = mid;
                } else {
                    min = mid + 1;
                }
            }
            System.out.println(result);
        }
    }
}
