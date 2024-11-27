public class programmers약수의개수와덧셈 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for (int i = left; i <= right; i++) {
                int count = 0;
                /*
                 * 약수의 개수 구하기
                 * 1 ~ i 까지 돌면 O(n)
                 * 1 ~ sqrt(i) 까지 돌면 O(sqrt(i)), 약수의 개수의 절반을 구할수 있다.
                 * 구한값을 2배 해주면 되고 약수가 sqrt(i)인경우 1개만 카운트한다.
                 */
                for (int j = 1; j * j <= i; j++) {
                    if (j * j == i) {
                        count++;
                    } else if (i % j == 0) {
                        count += 2;
                    }
                }
                if (count % 2 == 0) {
                    answer += i;
                } else {
                    answer -= i;
                }
            }

            return answer;
        }
    }
}
