import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15663 {
    static int n;
    static int m;
    static int[] input;
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        arr = new int[m];
        visit = new boolean[n];
        st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs(0);
        writer.flush();
        writer.close();
    }

    static void dfs(int depth) throws IOException {
        if (depth == m) {
            for (int i : arr) {
                writer.write(i + " ");
            }
            writer.write("\n");
            return;
        }
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                if (last != input[i]) {
                    visit[i] = true;
                    arr[depth] = input[i];
                    last = arr[depth];
                    dfs(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
