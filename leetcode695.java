import java.util.LinkedList;
import java.util.Queue;

// Max Area of Island
public class leetcode695 {
    class Solution {
        static boolean[][] visit;
        static int[] dx = { -1, 1, 0, 0 };
        static int[] dy = { 0, 0, -1, 1 };

        public int maxAreaOfIsland(int[][] grid) {
            visit = new boolean[grid.length][grid[0].length];
            int answer = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        answer = Math.max(answer, check(grid, i, j, 1));
                    }
                }
            }

            return answer;
        }

        private int check(int[][] grid, int x, int y, int count) {
            visit[x][y] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] { x, y });

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int mx = now[0] + dx[i];
                    int my = now[1] + dy[i];
                    if (mx < 0 || my < 0 || mx >= grid.length || my >= grid[0].length || grid[mx][my] == 0
                            || visit[mx][my]) {
                        continue;
                    }

                    queue.offer(new int[] { mx, my });
                    visit[mx][my] = true;
                    count++;
                }
            }

            return count;
        }
    }
}
