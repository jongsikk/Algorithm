import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1026 {
    static int n;
    static int[] a;
    static int[] b;
    static int max;
    static int index;
    static int sum;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(reader.readLine());
        a = new int[n];
        b = new int[n];
        index = 0;
        max = Integer.MIN_VALUE;

        st = new StringTokenizer(reader.readLine());
        for (int j = 0; j < n; j++) {
            a[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine());
        for (int j = 0; j < n; j++) {
            b[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < b[j] && b[j] != -1) {
                    max = b[j];
                    index = j;
                }

            }
            sum += max * a[i];
            b[index] = -1;
            max = Integer.MIN_VALUE;
        }
        System.out.println(sum);
    }
}
