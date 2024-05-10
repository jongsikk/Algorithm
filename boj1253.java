import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1253 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                if (arr[left] + arr[right] == arr[i]) {
                    if (left == i) {
                        left++;
                    } else if (right == i) {
                        right--;
                    } else {
                        count++;
                        break;
                    }
                } else if (arr[left] + arr[right] > arr[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(count);
    }
}
