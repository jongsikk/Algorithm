public class programmersN진수게임 {
    class Solution {
        /*
         * 문제 이해하는데 한세월걸림
         * Integer.toString(i, n) 써서 p의 turn이 될 때 마다 추가
         */
        public String solution(int n, int t, int m, int p) {
            StringBuilder answer = new StringBuilder();

            int num = 0;
            int index = 0;
            int turn = 1;

            for (int i = 0; i < t * m; i++) {
                String s = Integer.toString(num, n).toUpperCase();
                if (turn == p) {
                    answer.append(s.charAt(index));

                }
                turn++;
                if (turn == m + 1) {
                    turn = 1;
                }
                index++;
                if (index == s.length()) {
                    index = 0;
                    num++;
                }
            }

            return answer.toString();
        }
    }
}
