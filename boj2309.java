import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2309 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(reader.readLine());
            sum += input[i];
        }
        Arrays.sort(input);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sum - input[i] - input[j] == 100) {
                    input[i] = 0;
                    input[j] = 0;
                    break;
                }
            }
            if (input[i] == 0) {
                break;
            }
        }
        for (int i : input) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }
}
