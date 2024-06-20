import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12891 {
    static int[] count = new int[100];
    static int[] resultCount = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String line = reader.readLine();

        st = new StringTokenizer(reader.readLine());
        count['A'] = Integer.parseInt(st.nextToken());
        count['C'] = Integer.parseInt(st.nextToken());
        count['G'] = Integer.parseInt(st.nextToken());
        count['T'] = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < p; i++) {
            resultCount[line.charAt(i)]++;
        }
        if (check()) {
            answer++;
        }
        for (int i = p; i < s; i++) {
            resultCount[line.charAt(i - p)]--;
            resultCount[line.charAt(i)]++;
            if (check()) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean check() {
        return count['A'] <= resultCount['A'] && count['C'] <= resultCount['C'] && count['G'] <= resultCount['G']
                && count['T'] <= resultCount['T'];
    }
}
