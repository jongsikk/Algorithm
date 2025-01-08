import java.util.*;

public class programmers숫자변환하기 {
    static class Solution {
        static int answer;
        static boolean[] visit;

        public int solution(int x, int y, int n) {
            answer = Integer.MAX_VALUE;
            visit = new boolean[y + 1];

            bfs(x, y, n);

            return answer == Integer.MAX_VALUE ? -1 : answer;
        }

        static void bfs(int x, int y, int n) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] { x, 0 });
            visit[x] = true;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                if (now[0] == y) {
                    answer = now[1];
                    break;
                }
                if (now[1] > answer) {
                    continue;
                }

                if (now[0] + n <= y && !visit[now[0] + n]) {
                    queue.add(new int[] { now[0] + n, now[1] + 1 });
                    visit[now[0] + n] = true;
                }
                if (now[0] * 2 <= y && !visit[now[0] * 2]) {
                    queue.add(new int[] { now[0] * 2, now[1] + 1 });
                    visit[now[0] * 2] = true;
                }
                if (now[0] * 3 <= y && !visit[now[0] * 3]) {
                    queue.add(new int[] { now[0] * 3, now[1] + 1 });
                    visit[now[0] * 3] = true;
                }
            }
        }
    }
}
