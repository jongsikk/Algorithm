import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11726 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[1000];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        System.out.println(arr[n - 1]);
    }
}
