public class programmers마법의엘리베이터 {
    /*
     * 한 자리씩 끊어서 봤는데
     * 5가 남은 경우에 분기를 잘못해서 계속 틀렸다
     */
    class Solution {
        public int solution(int storey) {
            int answer = 0;

            while (storey != 0) {
                int remain = storey % 10;
                storey /= 10;

                if (remain < 5 || (remain == 5 && storey % 10 < 5)) {
                    answer += remain;
                } else {
                    answer += (10 - remain);
                    storey += 1;
                }
            }

            return answer;
        }
    }
}
