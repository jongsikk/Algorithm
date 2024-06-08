import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int an = Integer.parseInt(st.nextToken());
        int bn = Integer.parseInt(st.nextToken());
        int[] a = new int[an];
        int[] b = new int[bn];
        int[] result = new int[an + bn];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < an; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < bn; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < an && j < bn) {
            if (a[i] >= b[j]) {
                result[index++] = b[j++];
            } else {
                result[index++] = a[i++];
            }
        }
        if (i == an) {
            for (int k = j; k < bn; k++) {
                result[index++] = b[j++];
            }
        }
        if (j == bn) {
            for (int k = i; k < an; k++) {
                result[index++] = a[i++];
            }
        }
        for (int k = 0; k < an + bn; k++) {
            sb.append(result[k] + " ");
        }
        System.out.println(sb);
    }
}
