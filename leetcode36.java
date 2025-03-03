import java.util.HashSet;
import java.util.Set;

public class leetcode36 {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    if (!check3x3(board, i, j)) {
                        return false;
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                Set<Character> rowCheck = new HashSet<>();
                Set<Character> colCheck = new HashSet<>();

                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (!rowCheck.contains(board[i][j])) {
                            rowCheck.add(board[i][j]);
                        } else {
                            return false;
                        }
                    }

                    if (board[j][i] != '.') {
                        if (!colCheck.contains(board[j][i])) {
                            colCheck.add(board[j][i]);
                        } else {
                            return false;
                        }
                    }
                }
            }

            return true;
        }

        boolean check3x3(char[][] board, int x, int y) {
            Set<Character> sqCheck = new HashSet<>();

            for (int i = x; i < x + 3; i++) {
                for (int j = y; j < y + 3; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (sqCheck.contains(board[i][j])) {
                        return false;
                    } else {
                        sqCheck.add(board[i][j]);
                    }
                }
            }

            return true;
        }
    }
}
