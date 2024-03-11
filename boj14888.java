import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj14888 {
    private static int[] numbers;
    private static int[] ops = new int[4];
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ops = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        op(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void op(int number, int index) {
        if (index == n) {
            max = number > max ? number : max;
            min = number < min ? number : min;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                if (i == 0) {
                    op(number + numbers[index], index + 1);
                } else if (i == 1) {
                    op(number - numbers[index], index + 1);
                } else if (i == 2) {
                    op(number * numbers[index], index + 1);
                } else if (i == 3) {
                    op(number / numbers[index], index + 1);
                }
                ops[i]++;
            }
        }
    }
}
