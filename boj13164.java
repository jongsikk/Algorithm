import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int[] array = new int[n];
        int[] cost = new int[n - 1];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        for (int i = 0; i < n - 1; i++) {
            cost[i] = array[i + 1] - array[i];
        }
        Arrays.sort(cost);
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += cost[i];
        }
        System.out.println(sum);
    }
}
