public class programmers쿼드압축후개수세기 {
    class Solution {
        static int[] answer;

        public int[] solution(int[][] arr) {
            answer = new int[2];
            quadTree(arr, 0, 0, arr.length);

            return answer;
        }

        static void quadTree(int[][] arr, int x, int y, int size) {
            int num = check(arr, x, y, size);
            if (num != -1) {
                answer[num]++;
                return;
            }

            int quad = size / 2;
            quadTree(arr, x, y, quad);
            quadTree(arr, x, y + quad, quad);
            quadTree(arr, x + quad, y, quad);
            quadTree(arr, x + quad, y + quad, quad);
        }

        static int check(int[][] arr, int x, int y, int size) {
            int num = arr[x][y];
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (arr[i][j] != num) {
                        return -1;
                    }
                }
            }

            return num;
        }
    }
}
