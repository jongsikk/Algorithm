import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1806_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        while (right < n) {
            sum += input[right];
            if (sum >= s) {
                while (sum >= s) {
                    answer = Math.min(answer, right - left + 1);
                    sum -= input[left++];
                }
            }
            right++;
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
