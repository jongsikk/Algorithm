import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj6603 {
    static int n;
    static int[] input;
    static int[] array;
    static boolean[] visit;
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = "";
        while (!(line = reader.readLine()).equals("0")) {
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            input = new int[n];
            array = new int[6];
            visit = new boolean[n];

            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input);

            dfs(0, 0);

            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                writer.write(array[i] + " ");
            }
            writer.write("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                array[depth] = input[i];
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
