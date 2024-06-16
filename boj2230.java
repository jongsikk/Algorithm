import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while (end < n) {
            int sub = arr[end] - arr[start];
            if (sub < m) {
                end++;
            } else if (sub > m) {
                start++;
                min = Math.min(min, sub);
            } else {
                min = sub;
                break;
            }
        }
        System.out.println(min);
    }
}
