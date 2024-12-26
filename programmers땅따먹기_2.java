public class programmers땅따먹기_2 {
    class Solution {
        /*
         * 2가지로 풀었는데 알고보니 예전에 푼 문제였음
         * 왜 안푼문제에 뜬건지는 모르지만
         * 다르게 푼게 있으니까 패스
         */
        int solution(int[][] land) {
            int answer = 0;
            for (int i = 1; i < land.length; i++) {
                for (int j = 0; j < 4; j++) {
                    int max = 0;
                    for (int k = 0; k < 4; k++) {
                        if (j != k && max < land[i - 1][k]) {
                            max = land[i - 1][k];
                        }
                    }
                    land[i][j] += max;
                }
            }

            for (int i = 0; i < 4; i++) {
                answer = Math.max(answer, land[land.length - 1][i]);
            }

            return answer;
        }

        int solution2(int[][] land) {
            int answer = 0;
            for (int i = 0; i < land.length - 1; i++) {
                land[i + 1][0] += Math.max(land[i][1], Math.max(land[i][2], land[i][3]));
                land[i + 1][1] += Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
                land[i + 1][2] += Math.max(land[i][0], Math.max(land[i][1], land[i][3]));
                land[i + 1][3] += Math.max(land[i][0], Math.max(land[i][1], land[i][2]));
            }

            for (int i = 0; i < 4; i++) {
                answer = Math.max(answer, land[land.length - 1][i]);
            }

            return answer;
        }
    }
}
