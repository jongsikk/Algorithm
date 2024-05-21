class programmers삼각달팽이 {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[] dx = { 1, 0, -1 };
        int[] dy = { 0, 1, -1 };
        int[][] map = new int[n][n];
        int x = -1;
        int y = 0;
        int value = 1;
        int count = 0;
        int m = n;
        while (m > 0) {
            for (int i = 0; i < m; i++) {
                x += dx[count % 3];
                y += dy[count % 3];
                map[x][y] = value++;
            }
            count++;
            m--;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0)
                    answer[index++] = map[i][j];
            }
        }
        return answer;
    }
}
