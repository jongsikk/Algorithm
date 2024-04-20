import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1946 {
    static int t;
    static int n;
    static int count;
    static Score[] scores;
    static StringTokenizer st;
    static BufferedReader reader;
    static BufferedWriter writer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            count = 0;
            n = Integer.parseInt(reader.readLine());
            scores = new Score[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(reader.readLine());
                int docs = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                scores[j] = new Score(docs, interview);
            }
            Arrays.sort(scores, (s1, s2) -> (s1.docs - s2.docs));
            int temp = scores[0].interview;
            for (int j = 1; j < n; j++) {
                if (scores[j].interview < temp) {
                    temp = scores[j].interview;
                    count++;
                }
            }
            writer.write(count + 1 + "\n");
        }
        writer.flush();
        writer.close();

    }

    static class Score {
        int docs;
        int interview;

        Score(int docs, int interview) {
            this.docs = docs;
            this.interview = interview;
        }
    }
}
