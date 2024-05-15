import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj18511 {
    static int[] arr;
    static int k;
    static int n;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        recur(0);
        System.out.println(result);
    }

    static void recur(int start) {
        if (start > n) {
            return;
        }
        result = Math.max(result, start);

        for (int i = 0; i < k; i++) {
            recur(start * 10 + arr[i]);
        }
    }
}
