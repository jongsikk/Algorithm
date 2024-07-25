import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj30804 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] input = new int[n];
        int[] visit = new int[10];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int fruit = 0;
        int kind = 0;
        int max = 0;

        while (right < n) {
            if (visit[input[right]] == 0) {
                kind++;
            }
            visit[input[right]]++;
            fruit++;
            if (kind > 2) {
                visit[input[left]]--;
                if (visit[input[left]] == 0) {
                    kind--;
                }
                left++;
                fruit--;
            }
            right++;
            max = Math.max(max, fruit);
        }
        System.out.println(max);
    }
}
