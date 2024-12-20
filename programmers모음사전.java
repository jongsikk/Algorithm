public class programmers모음사전 {
    class Solution {
        static int answer;
        static int count;
        static char[] aeiou;

        public int solution(String word) {
            answer = 0;
            aeiou = new char[] { 'A', 'E', 'I', 'O', 'U' };
            dfs(new StringBuilder(), word);

            return answer;
        }

        static void dfs(StringBuilder now, String target) {
            if (now.toString().equals(target)) {
                answer = count;
                return;
            }
            if (now.length() >= 5) {
                return;
            }
            for (int i = 0; i < 5; i++) {
                now.append(aeiou[i]);
                count++;
                dfs(now, target);
                now.deleteCharAt(now.length() - 1);
            }
        }
    }
}
