import java.util.*;

public class programmers무인도여행 {
    class Solution {
        int width;
        int height;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        String[][] map;
        boolean[][] visit;

        public int[] solution(String[] maps) {
            List<Integer> answer = new ArrayList<>();
            width = maps[0].length();
            height = maps.length;
            map = new String[height][width];
            visit = new boolean[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    map[i][j] = maps[i].charAt(j) + "";
                }
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!map[i][j].equals("X") && !visit[i][j]) {
                        answer.add(bfs(i, j));
                    }
                }
            }

            Collections.sort(answer);

            return answer.size() == 0 ? new int[] { -1 } : answer.stream().mapToInt(Integer::intValue).toArray();
        }

        public int bfs(int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            visit[x][y] = true;
            q.offer(new int[] { x, y });
            int sum = Integer.parseInt(map[x][y]);

            while (!q.isEmpty()) {
                int[] now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int mx = now[0] + dx[i];
                    int my = now[1] + dy[i];

                    if (mx < 0 || mx >= height || my < 0 || my >= width || visit[mx][my] || map[mx][my].equals("X")) {
                        continue;
                    }
                    visit[mx][my] = true;
                    q.offer(new int[] { mx, my });
                    sum += Integer.parseInt(map[mx][my]);
                }
            }

            return sum;
        }
    }
}
