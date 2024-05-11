import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);

        int min = 1;
        int max = arr[n - 1];
        while (min <= max) {
            int count = 1;
            int last = arr[0];
            int mid = (min + max) / 2;
            for (int i = 1; i < n; i++) {
                if (arr[i] - last >= mid) {
                    last = arr[i];
                    count++;
                }
            }
            if (count < c) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
