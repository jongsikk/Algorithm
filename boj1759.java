import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759 {
    static int l;
    static int c;
    static int[] input;
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        input = new int[c];
        arr = new int[l];
        visit = new boolean[c];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < c; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);

        dfs(0, 0, 0, 0);

        writer.flush();
        writer.close();
    }

    static void dfs(int depth, int start, int aeiou, int other) throws IOException {
        if (depth == l) {
            if (aeiou > 0 && other > 1) {
                for (int i = 0; i < l; i++) {
                    writer.write(arr[i]);
                }
                writer.write("\n");
            }
            return;
        }
        for (int i = start; i < c; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = input[i];
                if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u')
                    dfs(depth + 1, i + 1, aeiou + 1, other);
                else
                    dfs(depth + 1, i + 1, aeiou, other + 1);
                visit[i] = false;
            }
        }
    }
}