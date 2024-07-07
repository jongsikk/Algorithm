import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15686 {
    static int n;
    static int m;
    static int answer;
    static List<Point> home;
    static List<Point> chicken;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1)
                    home.add(new Point(i, j));
                else if (num == 2)
                    chicken.add(new Point(i, j));
            }
        }
        visit = new boolean[chicken.size()];

        dfs(0, 0);

        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }

    static void dfs(int index, int depth) {
        if (depth == m) {
            int sum = 0;

            for (int j = 0; j < home.size(); j++) {
                int d = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (visit[i]) {
                        int dist = Math.abs(home.get(j).x - chicken.get(i).x)
                                + Math.abs(home.get(j).y - chicken.get(i).y);
                        d = Math.min(d, dist);
                    }
                }
                sum += d;
            }

            answer = Math.min(answer, sum);
            return;
        }

        for (int i = index; i < chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
