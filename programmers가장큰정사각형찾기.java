public class programmers가장큰정사각형찾기 {
    class Solution {
        public int solution(int[][] board) {
            int answer = -1;
            int[][] rect = new int[board.length][board[0].length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 1) {
                        if (i == 0 || j == 0) {
                            rect[i][j] = 1;
                        } else {
                            int size = Math.min(rect[i - 1][j - 1], Math.min(rect[i - 1][j], rect[i][j - 1]));
                            rect[i][j] = size + 1;
                        }
                    }
                    answer = Math.max(rect[i][j], answer);
                }
            }

            return answer * answer;
        }
    }
}
