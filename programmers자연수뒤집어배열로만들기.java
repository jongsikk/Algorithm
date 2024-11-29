public class programmers자연수뒤집어배열로만들기 {
    class Solution {
        public int[] solution(long n) {
            String s = n + "";
            int[] answer = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                answer[s.length() - i - 1] = s.charAt(i) - '0';
            }

            return answer;
        }
    }
}
