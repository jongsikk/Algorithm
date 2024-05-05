import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2776 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(reader.readLine());
            int[] n1 = new int[n];
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                n1[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(reader.readLine());
            int[] m1 = new int[m];
            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < m; i++) {
                m1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(n1);

            for (int i = 0; i < m; i++) {
                writer.write(binary(n1, m1[i]) + "\n");
            }
            writer.flush();
        }
        writer.close();
    }

    static int binary(int[] n1, int x) {
        int min = 0;
        int max = n1.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (n1[mid] == x) {
                return 1;
            } else if (x < n1[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return 0;
    }
}
