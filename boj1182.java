import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1182 {
    static int n;
    static int s;
    static int answer;
    static int[] arr;
    static int[] input;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        answer = 0;
        arr = new int[n];
        input = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (s == 0)
            answer--;
        System.out.println(answer);
    }

    static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }
        dfs(depth + 1, sum + input[depth]);
        dfs(depth + 1, sum);
    }
}
