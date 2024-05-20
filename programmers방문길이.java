public class programmers방문길이 {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] map = new boolean[11][11][4];
        int x = 5;
        int y = 5;

        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'U') {
                if (y < 10 && !map[x][++y][0] && !map[x][y - 1][1]) {
                    map[x][y][0] = true;
                    map[x][y - 1][1] = true;
                    answer++;
                }
            } else if (dirs.charAt(i) == 'D') {
                if (y > 0 && !map[x][--y][1] && !map[x][y + 1][0]) {
                    map[x][y][1] = true;
                    map[x][y + 1][0] = true;
                    answer++;
                }
            } else if (dirs.charAt(i) == 'L') {
                if (x > 0 && !map[--x][y][2] && !map[x + 1][y][3]) {
                    map[x][y][2] = true;
                    map[x + 1][y][3] = true;
                    answer++;
                }
            } else if (dirs.charAt(i) == 'R') {
                if (x < 10 && !map[++x][y][3] && !map[x - 1][y][2]) {
                    map[x][y][3] = true;
                    map[x - 1][y][2] = true;
                    answer++;
                }
            }

        }
        return answer;
    }
}
