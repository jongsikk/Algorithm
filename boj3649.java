import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj3649 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = reader.readLine()) != null) {
            int x = Integer.parseInt(line) * 10000000;
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(reader.readLine());
            }
            Arrays.sort(arr);
            int start = 0;
            int end = n - 1;
            int result = Integer.MIN_VALUE;
            int result1 = 0;
            int result2 = 0;
            while (start < end) {
                if (arr[start] + arr[end] < x) {
                    start++;
                } else if (arr[start] + arr[end] > x) {
                    end--;
                } else {
                    if (arr[end] - arr[start] > result) {
                        result = arr[end] - arr[start];
                        result1 = start;
                        result2 = end;
                    }
                    start++;
                }
            }
            if (result == Integer.MIN_VALUE) {
                System.out.println("danger");
            } else {
                System.out.println(String.format("yes %s %s", arr[result1], arr[result2]));
            }
        }
    }
}
