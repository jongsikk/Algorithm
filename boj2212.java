import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj2212 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] arr = new int[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            distance[i] = arr[i + 1] - arr[i];
        }
        Integer[] arr_integer = Arrays.stream(distance).boxed().toArray(Integer[]::new);
        Arrays.sort(arr_integer, Collections.reverseOrder());
        int sum = 0;
        for (int i = k - 1; i < n; i++) {
            sum += arr_integer[i];
        }
        System.out.println(sum);
    }
}
