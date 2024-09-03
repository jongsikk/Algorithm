import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1062 {
    static int n;
    static int k;
    static int answer;
    static String[] words;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[124];
        visit['a'] = true;
        visit['n'] = true;
        visit['t'] = true;
        visit['i'] = true;
        visit['c'] = true;

        words = new String[n];
        for (int i = 0; i < n; i++) {
            String aWord = reader.readLine();
            String word = aWord.substring(4, aWord.length() - 4);
            words[i] = word;
        }
        if (k < 5) {
            System.out.println(0);
        } else if (k == 26) {
            System.out.println(n);
        } else {
            bt('a', 0);
            System.out.println(answer);
        }
    }

    static void bt(char alphabet, int len) {
        if (len == k - 5) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean ok = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visit[words[i].charAt(j)]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    count++;
                }
            }
            answer = Math.max(count, answer);
            return;
        }
        for (char c = alphabet; c <= 'z'; c++) {
            if (!visit[c]) {
                visit[c] = true;
                bt(c, len + 1);
                visit[c] = false;
            }
        }
    }
}