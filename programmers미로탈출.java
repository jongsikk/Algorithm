import java.util.*;

public class programmers미로탈출 {
    class Solution {
        int answer;
        int xLength;
        int yLength;
        int[] start;
        int[] lever;
        int[] end;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        public int solution(String[] maps) {
            answer = Integer.MAX_VALUE;
            xLength = maps.length;
            yLength = maps[0].length();
            start = new int[2];
            lever = new int[2];
            end = new int[2];

            for (int i = 0; i < maps.length; i++) {
                for (int j = 0; j < maps[i].length(); j++) {
                    if (maps[i].charAt(j) == 'S') {
                        start[0] = i;
                        start[1] = j;
                    } else if (maps[i].charAt(j) == 'L') {
                        lever[0] = i;
                        lever[1] = j;
                    } else if (maps[i].charAt(j) == 'E') {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }

            int toL = bfs(maps, start, lever);
            int toE = bfs(maps, lever, end);

            return (toL == 0 || toE == 0) ? -1 : toL + toE;
        }

        public int bfs(String[] maps, int[] s, int[] e) {
            Queue<int[]> q = new LinkedList<>(); // {x, y, time}
            boolean[][] visit = new boolean[xLength][yLength];
            q.offer(new int[] { s[0], s[1], 0 });
            visit[s[0]][s[1]] = true;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int nx = now[0];
                int ny = now[1];
                for (int i = 0; i < 4; i++) {
                    int mx = nx + dx[i];
                    int my = ny + dy[i];
                    if (mx == e[0] && my == e[1]) {
                        return now[2] + 1;
                    }
                    if (mx >= 0 && mx < xLength && my >= 0 && my < yLength && !visit[mx][my]
                            && maps[mx].charAt(my) != 'X') {
                        visit[mx][my] = true;
                        q.offer(new int[] { mx, my, now[2] + 1 });
                    }
                }
            }

            return 0;
        }
    }
}
