public class programmers크기가작은부분문자열 {
    class Solution {
        /*
         * p의 길이가 18까지인데 int로 비교해서 런타임에러뜸
         * long으로 바꿔주니 통과
         */
        public int solution(String t, String p) {
            int answer = 0;
            long ip = Long.parseLong(p);

            for (int i = 0; i <= t.length() - p.length(); i++) {
                if (Long.parseLong(t.substring(i, i + p.length())) <= ip) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
