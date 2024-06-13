import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> index = new ArrayList<>();
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                index.add(i);
            }
        }
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < index.size() - k + 1; i++) {
            start = index.get(i);
            end = index.get(i + k - 1);
            min = Math.min(min, end - start + 1);
        }

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }
}
