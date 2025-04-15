public class leetcode529 {
    class Solution {
        static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        public char[][] updateBoard(char[][] board, int[] click) {
            if (board[click[0]][click[1]] == 'M') {
                board[click[0]][click[1]] = 'X';
                return board;
            }
            solution(board, click[0], click[1]);

            return board;
        }

        private void solution(char[][] board, int x, int y) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') {
                return;
            }

            board[x][y] = '0';
            for (int i = 0; i < 8; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= board.length || my >= board[0].length) {
                    continue;
                }
                if (board[mx][my] == 'M') {
                    board[x][y]++;
                }
            }

            if (board[x][y] != '0') {
                return;
            }

            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                solution(board, mx, my);
            }
        }
    }
}
