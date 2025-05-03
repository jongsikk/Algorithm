public class programmers문자리스트를문자열로변환하기 {
    class Solution {
        public String solution(String[] arr) {
            StringBuffer sb = new StringBuffer();
            for (String s : arr) {
                sb.append(s);
            }

            return sb.toString();
        }
    }
}
