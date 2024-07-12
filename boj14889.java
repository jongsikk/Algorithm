import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14889 {
    static int n;
    static int answer;
    static int[][] input;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        input = new int[n][n];
        visit = new boolean[n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int start) {
        if (depth == n / 2) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (visit[i] && visit[j]) {
                        sum1 += input[i][j];
                        sum1 += input[j][i];
                    } else if (!visit[i] && !visit[j]) {
                        sum2 += input[i][j];
                        sum2 += input[j][i];
                    }
                }
            }
            answer = Math.min(Math.abs(sum1 - sum2), answer);
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
