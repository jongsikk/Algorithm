import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj14226 {
    static int s;
    static int answer;
    static int[][] time;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(reader.readLine());
        time = new int[1001][1001];
        answer = Integer.MAX_VALUE;

        bfs(1, 0);

        System.out.println(answer);
    }

    static void bfs(int n, int clip) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { n, clip });
        time[n][clip] = 0;
        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            for (int i = 0; i < 3; i++) {
                int emoji = e[0];
                int clipboard = e[1];

                if (i == 0) {
                    clipboard = emoji;
                }
                if (i == 1) {
                    emoji += clipboard;
                }
                if (i == 2) {
                    emoji -= 1;
                }
                if (emoji == 0 || clipboard == 0 || emoji > 1000 || emoji < 0) {
                    continue;
                }
                if (emoji == s) {
                    answer = Math.min(answer, time[e[0]][e[1]] + 1);
                }
                if (time[emoji][clipboard] == 0 || time[emoji][clipboard] > time[e[0]][e[1]] + 1) {
                    time[emoji][clipboard] = time[e[0]][e[1]] + 1;
                    queue.add(new int[] { emoji, clipboard });
                }
            }
        }
    }
}
