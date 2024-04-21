import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char cur = s.charAt(0);
        int one = 0;
        int zero = 0;
        if (cur - '0' == 1) {
            one++;
        } else {
            zero++;
        }
        for (int i = 1; i < s.length(); i++) {
            if (cur != s.charAt(i)) {
                if ((cur - '0') == 0) {
                    one++;
                } else {
                    zero++;
                }
                cur = s.charAt(i);
            }
        }
        System.out.println(Math.min(one, zero));
    }
}
