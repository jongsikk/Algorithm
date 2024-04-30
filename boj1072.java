import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int) ((long) y * 100 / x);

        int min = 0;
        int max = x;
        if ((x - y) == 0 || (z == 99)) {
            System.out.println(-1);
        } else {
            while (min <= max) {
                int mid = (min + max) / 2;
                int ratio = (int) ((long) (y + mid) * 100 / (x + mid));
                if (ratio <= z) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }

            System.out.println(min);
        }
    }
}
