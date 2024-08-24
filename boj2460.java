import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int now = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(reader.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            now += in;
            now -= out;
            max = Math.max(max, now);
        }
        System.out.println(max);
    }
}
