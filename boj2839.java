import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2839 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(sugar(n));
    }

    private static int sugar(int n) {
        if (n == 4 || n == 7) {
            return -1;
        }
        if (n % 5 == 3 || n % 5 == 1) {
            return n / 5 + 1;
        }
        if (n % 5 == 0) {
            return n / 5;
        }
        if (n % 5 == 4 || n % 5 == 2) {
            return n / 5 + 2;
        }
        return -2;
    }
}
