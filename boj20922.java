import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] count = new int[100001];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int result = 0;
        while (end < n) {
            if (count[arr[end]] < k) {
                count[0]++;
                count[arr[end++]]++;
            } else {
                result = Math.max(count[0], result);
                count[0]--;
                count[arr[start]]--;
                start++;
            }
            if (end == n) {
                result = Math.max(count[0], result);
            }
        }
        System.out.println(result);
    }
}
