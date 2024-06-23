import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[2 * n];
        int[] count = new int[d + 1];

        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(reader.readLine());
            arr[i] = j;
            arr[i + n] = j;
        }
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            int j = arr[i];
            if (count[j] == 0) {
                cnt++;
            }
            count[j]++;
        }
        int answer = cnt;
        for (int i = k; i < n + k; i++) {
            if (count[arr[i - k]] == 1) {
                cnt--;
            }
            count[arr[i - k]]--;
            if (count[arr[i]] == 0) {
                cnt++;
            }
            count[arr[i]]++;
            if (answer <= cnt) {
                if (count[c] == 0) {
                    answer = cnt + 1;
                } else {
                    answer = cnt;
                }
            }
        }
        System.out.println(answer);
    }
}
