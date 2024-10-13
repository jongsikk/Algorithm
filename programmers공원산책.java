public class programmers공원산책 {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[] { -1, -1 };
            int height = park.length;
            int width = park[0].length();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (park[i].charAt(j) == 'S') {
                        answer[0] = i;
                        answer[1] = j;
                        break;
                    }
                }
                if (answer[0] != -1) {
                    break;
                }
            }

            for (int i = 0; i < routes.length; i++) {
                String[] route = routes[i].split(" ");
                String direction = route[0];
                int n = Integer.parseInt(route[1]);
                int dx = answer[0];
                int dy = answer[1];
                boolean flag = true;

                if ("N".equals(direction)) {
                    for (int j = 0; j < n; j++) {
                        if (dx - j < 0 || park[dx - j].charAt(dy) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    dx -= n;
                } else if ("S".equals(direction)) {
                    for (int j = 0; j < n; j++) {
                        if (dx + j >= height || park[dx + j].charAt(dy) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    dx += n;
                } else if ("W".equals(direction)) {
                    for (int j = 0; j < n; j++) {
                        if (dy - j < 0 || park[dx].charAt(dy - j) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    dy -= n;
                } else if ("E".equals(direction)) {
                    for (int j = 0; j < n; j++) {
                        if (dy + j >= width || park[dx].charAt(dy + j) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    dy += n;
                }

                if (dx < 0 || dx >= height || dy < 0 || dy >= width || park[dx].charAt(dy) == 'X') {
                    continue;
                }

                answer[0] = dx;
                answer[1] = dy;
            }

            return answer;
        }
    }
}
