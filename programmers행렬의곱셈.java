public class programmers행렬의곱셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];
            for (int i = 0; i < arr1.length; i++) {
                for (int ii = 0; ii < arr2[0].length; ii++) {
                    int sum = 0;
                    for (int jj = 0; jj < arr1[0].length; jj++) {
                        sum += arr1[i][jj] * arr2[jj][ii];
                    }
                    answer[i][ii] = sum;
                }
            }

            return answer;
        }
    }
}
