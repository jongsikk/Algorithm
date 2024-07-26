import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] input = new int[n];
        int[] sort = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            sort[i] = input[i];
        }
        Arrays.sort(sort);
        int count = 0;
        int min = sort[0];
        for (int i = 0; i < n; i++) {
            if (sort[i] != min) {
                count++;
                min = sort[i];
            }
            map.put(sort[i], count);
        }
        for (int i = 0; i < n; i++) {
            writer.write(map.get(input[i]) + " ");
        }
        writer.flush();
        writer.close();
    }
}
