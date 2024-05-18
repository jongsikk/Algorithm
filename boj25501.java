import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj25501 {
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            count = 0;
            String s = reader.readLine();
            System.out.println(recursion(s, 0, s.length() - 1) + " " + count);
        }
    }

    public static int recursion(String s, int l, int r) {
        count++;
        if (l >= r)
            return 1;
        else if (s.charAt(l) != s.charAt(r))
            return 0;
        else {
            return recursion(s, l + 1, r - 1);
        }
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

}
