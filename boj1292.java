import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] sum = new int[1001];
        int index = 1;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++) {
                if (index > 1000) {
                    break;
                }
                sum[index++] = i;
            }
        }
        int answer = 0;
        for (int i = a; i <= b; i++) {
            answer += sum[i];
        }
        System.out.println(answer);
    }
}
