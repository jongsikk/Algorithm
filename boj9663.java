import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9663 {
    static int n;
    static int answer;
    static int[] queen;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        answer = 0;
        queen = new int[n];

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            queen[depth] = i;
            if (check(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            if (queen[depth] == queen[i]) {
                return false;
            } else if (Math.abs(depth - i) == Math.abs(queen[depth] - queen[i])) {
                return false;
            }
        }
        return true;
    }
}
