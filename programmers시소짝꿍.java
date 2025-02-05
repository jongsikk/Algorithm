public class programmers시소짝꿍 {
    class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            int[] count = new int[1001];
            int[] multiCount = new int[4001];

            for (int i = 0; i < weights.length; i++) {
                int now = count[weights[i]];
                int m2 = weights[i] * 2;
                int m3 = weights[i] * 3;
                int m4 = weights[i] * 4;

                if (now != 0) {
                    answer += now;
                    answer += multiCount[m2] - now;
                    answer += multiCount[m3] - now;
                    answer += multiCount[m4] - now;
                } else {
                    answer += multiCount[m2];
                    answer += multiCount[m3];
                    answer += multiCount[m4];
                }

                count[weights[i]]++;
                multiCount[m2]++;
                multiCount[m3]++;
                multiCount[m4]++;
            }

            return answer;
        }

    }
}
