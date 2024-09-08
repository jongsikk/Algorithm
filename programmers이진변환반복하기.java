public class programmers이진변환반복하기 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            int len = s.length();
            while (!"1".equals(s)) {
                len = s.length();
                s = s.replace("0", "");
                answer[1] += (len - s.length());
                len = s.length();
                s = Integer.toBinaryString(len);
                answer[0]++;
            }

            return answer;
        }
    }
}
