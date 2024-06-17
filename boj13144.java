import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13144 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        int[] count = new int[100001];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = -1;
        long answer = 0;

        while (start < n) {
            if (end + 1 < n && count[arr[end + 1]] < 1) {
                end++;
                count[arr[end]]++;
            } else {
                answer += end - start + 1;
                count[arr[start++]]--;
            }
        }
        System.out.println(answer);
    }
}
