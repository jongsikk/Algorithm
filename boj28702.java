import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int now = 0;
        int index = 0;
        for (int i = 1; i <= 3; i++) {
            String s = reader.readLine();
            if (!(s.equals("Fizz") || s.equals("Buzz") || s.equals("FizzBuzz"))) {
                now = Integer.parseInt(s);
                index = i;
            }
        }

        now = now + 3 - index + 1;

        String answer = "";
        if (now % 3 == 0 && now % 5 == 0) {
            answer = "FizzBuzz";
        } else if (now % 3 == 0 && now % 5 != 0) {
            answer = "Fizz";
        } else if (now % 3 != 0 && now % 5 == 0) {
            answer = "Buzz";
        } else {
            answer = now + "";
        }

        System.out.println(answer);
    }
}
