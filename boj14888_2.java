import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888_2 {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine());
        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int count, int sum) {
        if (count == n - 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (i == 0 && operators[i] != 0) {
                operators[i]--;
                dfs(count + 1, sum + nums[count + 1]);
                operators[i]++;
            } else if (i == 1 && operators[i] != 0) {
                operators[i]--;
                dfs(count + 1, sum - nums[count + 1]);
                operators[i]++;
            } else if (i == 2 && operators[i] != 0) {
                operators[i]--;
                dfs(count + 1, sum * nums[count + 1]);
                operators[i]++;
            } else if (i == 3 && operators[i] != 0) {
                operators[i]--;
                dfs(count + 1, sum / nums[count + 1]);
                operators[i]++;
            }
        }
    }
}
