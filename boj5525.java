import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        String s = reader.readLine();

        char[] array = s.toCharArray();
        int count = 0;
        int answer = 0;
        for (int i = 0; i < m - 2; i++) {
            if (array[i] == 'I') {
                count = 0;
                while (i + 2 < m && array[i + 1] == 'O' && array[i + 2] == 'I') {
                    count++;
                    i += 2;
                    if (count == n) {
                        answer++;
                        count--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
