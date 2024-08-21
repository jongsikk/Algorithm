import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(mul(a, b, c));
    }

    static long mul(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long num = mul(a, b / 2, c);
        if (b % 2 == 0) {
            return num * num % c;
        } else {
            return (num * num % c) * a % c;
        }
    }
}
