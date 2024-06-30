import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj15652 {
    static int n;
    static int m;
    static int[] arr;
    static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
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
        for (int i = 0; i < n; i++) {
            if (depth == 0 || (depth > 0 && i + 1 >= arr[depth - 1])) {
                arr[depth] = i + 1;
                dfs(depth + 1);
            }
        }
    }
}
