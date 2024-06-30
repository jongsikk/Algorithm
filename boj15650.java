import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15650 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visit = new boolean[n];
        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                if (depth == 0 || (depth > 0 && i + 1 > arr[depth - 1])) {
                    visit[i] = true;
                    arr[depth] = i + 1;
                    dfs(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
