import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        int[] wall = new int[w];

        for (int i = 0; i < w; i++) {
            wall[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, wall[j]);
            }
            for (int j = i + 1; j < w; j++) {
                right = Math.max(right, wall[j]);
            }
            if (wall[i] < right && wall[i] < left) {
                sum += (Math.min(left, right) - wall[i]);
            }
        }
        System.out.println(sum);
    }
}
