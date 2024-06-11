import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3273 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int result = 0;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (arr[start] + arr[end] < m) {
                start++;
            } else if (arr[start] + arr[end] > m) {
                end--;
            } else {
                start++;
                end--;
                result++;
            }
        }
        System.out.println(result);
    }
}
