import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16928 {
    static int answer = Integer.MAX_VALUE;
    static int[] map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[101];
        visit = new boolean[101];
        for (int i = 1; i < 101; i++) {
            map[i] = i;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        System.out.println(game(1));
    }

    static int game(int start) {
        int[] count = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        count[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next <= 100 && count[map[next]] == 0) {
                    if (next == 100) {
                        return count[now] + 1;
                    }
                    count[map[next]] = count[now] + 1;
                    queue.add(map[next]);
                }
            }
        }

        return 0;
    }
}
