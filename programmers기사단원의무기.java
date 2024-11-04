public class programmers기사단원의무기 {
    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            int[] counts = new int[number + 1];

            for (int i = 1; i <= number; i++) {
                int count = 0;
                // i의 약수가 j일때 다른 약수는 i / j, 1 ~ sqrt(i) 까지의 약수를 구해서 * 2
                for (int j = 1; j * j <= i; j++) {
                    if (j * j == i) {
                        count++;
                    } else if (i % j == 0) {
                        count += 2;
                    }
                }
                if (count > limit) {
                    count = power;
                }
                counts[i] = count;
            }

            for (int i = 1; i <= number; i++) {
                answer += counts[i];
            }

            return answer;
        }
    }
}
