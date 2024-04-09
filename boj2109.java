import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2109 {
    static int n;
    static List<Lec> lecs;
    static int result;
    static boolean[] end;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        lecs = new ArrayList<>();
        result = 0;
        n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            lecs.add(new Lec(p, d));
        }

        lecs.sort((l1, l2) -> l1.d == l2.d ? l2.p - l1.p : l2.d - l1.d);
        end = new boolean[n];
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int day = lecs.get(0).d;
        while (day > 0) {
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                if (day <= lecs.get(i).d && !end[i]) {
                    if (lecs.get(i).p > max) {
                        max = lecs.get(i).p;
                        maxIndex = i;
                    }
                }
            }
            if (max != 0) {
                result += max;
                end[maxIndex] = true;
            }
            day--;
        }
        System.out.println(result);
    }

    static class Lec {
        int d;
        int p;

        public Lec(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }
}
