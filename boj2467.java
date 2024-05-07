import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2467 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            int temp = arr[left] + arr[right];
            if (Math.abs(temp) < min) {
                min = Math.abs(temp);
                result[0] = left;
                result[1] = right;
            }
            if (temp > 0) {
                right--;
            } else if (temp < 0) {
                left++;
            } else {
                result[0] = left;
                result[1] = right;
                break;
            }
        }
        System.out.println(arr[result[0]] + " " + arr[result[1]]);
    }
}
