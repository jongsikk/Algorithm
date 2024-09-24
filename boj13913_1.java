import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj13913_1 {
    static int n;
    static int k;
    static int[] time;
    static int[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        time = new int[100001];
        route = new int[100001];
        bfs(n);
        int end = k;

        Stack<Integer> stack = new Stack<>();
        do {
            stack.add(end);
            end = route[end];
        } while (end != n);
        stack.add(n);

        System.out.println(time[k] - 1);
        for (int i = 0; i < time[k]; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        time[start] = 1;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < 3; i++) {
                int mx = x;
                if (i == 0) {
                    mx -= 1;
                }
                if (i == 1) {
                    mx += 1;
                }
                if (i == 2) {
                    mx *= 2;
                }
                if (mx < 0 || mx > 100000) {
                    continue;
                }
                if (time[mx] == 0 || time[mx] > time[x] + 1) {
                    time[mx] = time[x] + 1;
                    queue.add(mx);
                    route[mx] = x;
                }
            }
        }
    }
}
