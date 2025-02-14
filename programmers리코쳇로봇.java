import java.util.*;

public class programmers리코쳇로봇 {
    class Solution {
        int answer;
        int xLength;
        int yLength;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        String[][] map;

        public int solution(String[] board) {
            answer = Integer.MAX_VALUE;
            xLength = board.length;
            yLength = board[0].length();
            int[] start = new int[2];
            int[] end = new int[2];
            map = new String[xLength][yLength];
            for (int i = 0; i < xLength; i++) {
                for (int j = 0; j < yLength; j++) {
                    map[i][j] = board[i].charAt(j) + "";
                    if ("R".equals(map[i][j])) {
                        start[0] = i;
                        start[1] = j;
                    } else if ("G".equals(map[i][j])) {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }
            bfs(start[0], start[1], end[0], end[1]);

            return answer == Integer.MAX_VALUE ? -1 : answer;
        }

        public void bfs(int startX, int startY, int endX, int endY) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] { startX, startY, 1 }); // 시작 x, y, count
            boolean[][] visit = new boolean[xLength][yLength];
            visit[startX][startY] = true;
            while (!q.isEmpty()) {
                int[] now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int mx = now[0];
                    int my = now[1];
                    while (mx + dx[i] >= 0 && mx + dx[i] < xLength && my + dy[i] >= 0
                            && my + dy[i] < yLength && !"D".equals(map[mx + dx[i]][my + dy[i]])) {
                        mx += dx[i];
                        my += dy[i];
                    }
                    if (!visit[mx][my]) {
                        if (mx == endX && my == endY) {
                            answer = Math.min(answer, now[2]);
                            return;
                        }
                        visit[mx][my] = true;
                        q.offer(new int[] { mx, my, now[2] + 1 });
                    }
                }
            }
        }
    }
}
