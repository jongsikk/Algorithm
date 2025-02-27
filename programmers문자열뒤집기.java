public class programmers문자열뒤집기 {
    class Solution {
        public String solution(String my_string) {
            StringBuilder answer = new StringBuilder();
            answer.append(my_string.toCharArray());

            return answer.reverse().toString();
        }
    }
}
