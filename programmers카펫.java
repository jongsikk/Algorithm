public class programmers카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int size = brown + yellow;
            for (int i = 3; i <= size; i++) {
                if (size % i == 0) {
                    int width = 0;
                    int height = 0;
                    if (i > size / i) {
                        width = i;
                        height = size / i;
                    } else {
                        width = size / i;
                        height = i;
                    }
                    int sum = width * 2 + (height * 2 - 4);
                    if (sum == brown) {
                        answer[0] = width;
                        answer[1] = height;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
