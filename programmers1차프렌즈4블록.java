public class programmers1차프렌즈4블록 {
    class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] b = new char[board.length][board[0].length()];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length(); j++) {
                    b[i][j] = board[i].charAt(j);
                }
            }

            while (true) {
                boolean exit = true;
                boolean[][] visit = new boolean[b.length][b[0].length];

                for (int i = 0; i < b.length - 1; i++) {
                    for (int j = 0; j < b[i].length - 1; j++) {
                        if (b[i][j] == ' ' || b[i][j + 1] == ' ' || b[i + 1][j] == ' ' || b[i + 1][j + 1] == ' ') {
                            continue;
                        }
                        if (b[i][j] != b[i][j + 1] || b[i][j] != b[i + 1][j] || b[i][j] != b[i + 1][j + 1]) {
                            continue;
                        }
                        if (!visit[i][j]) {
                            visit[i][j] = true;
                            answer++;
                        }
                        if (!visit[i][j + 1]) {
                            visit[i][j + 1] = true;
                            answer++;
                        }
                        if (!visit[i + 1][j]) {
                            visit[i + 1][j] = true;
                            answer++;
                        }
                        if (!visit[i + 1][j + 1]) {
                            visit[i + 1][j + 1] = true;
                            answer++;
                        }
                        exit = false;
                    }
                }

                if (exit) {
                    break;
                }

                for (int i = b.length - 1; i >= 0; i--) {
                    for (int j = 0; j < b[0].length; j++) {
                        if (visit[i][j]) {
                            boolean empty = true;
                            for (int k = i - 1; k >= 0; k--) {
                                if (b[k][j] != ' ' && !visit[k][j]) {
                                    b[i][j] = b[k][j];
                                    b[k][j] = ' ';
                                    visit[k][j] = true;
                                    empty = false;
                                    break;
                                }
                            }
                            if (empty) {
                                b[i][j] = ' ';
                            }
                        }
                    }
                }
            }

            return answer;
        }
    }
}
