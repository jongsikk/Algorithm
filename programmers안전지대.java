public class programmers안전지대 {
    class Solution {

        public int solution(int[][] board) {
            int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
            int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
            int n = board.length;
            int[][] map = new int[n][n];
            int answer = n * n;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        map[i][j] = 1;
                        for (int k = 0; k < 8; k++) {
                            int mx = i + x[k];
                            int my = j + y[k];
                            if (mx >= 0 && my >= 0 && mx < n && my < n && map[mx][my] == 0) {
                                map[mx][my] = 1;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        answer--;
                    }
                }
            }

            return answer;
        }
    }
}
