import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (end < n) {
            sum += arr[end];
            if (sum < s) {
                end++;
            } else {
                while (sum >= s) {
                    result = Math.min(result, end - start + 1);
                    sum -= arr[start++];
                }
                end++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            result = 0;
        }
        System.out.println(result);
    }
}
