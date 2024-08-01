import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj18110 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(array);
        int m = (int) Math.round(n * 0.15);
        double sum = 0;
        for (int i = m; i < n - m; i++) {
            sum += array[i];
        }
        System.out.println(Math.round(sum / (n - 2 * m)));
    }
}
