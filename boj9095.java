import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj9095 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[11];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3; i < 11; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(reader.readLine());
            System.out.println(arr[num - 1]);
        }
    }
}
