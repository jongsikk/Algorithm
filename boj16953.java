import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16953 {
    static int a;
    static int b;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        dfs(a, 1);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(long a, int count) {
        if (a == b) {
            answer = Math.min(count, answer);
            return;
        }
        if (a > b) {
            return;
        }
        dfs(a * 2, count + 1);
        dfs(a * 10 + 1, count + 1);
    }
}