import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1789_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(reader.readLine());
        long i = 1;
        while (i <= s) {
            s -= i++;
        }
        System.out.println(i - 1);
    }
}
