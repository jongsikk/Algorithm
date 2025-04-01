import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> answer = new ArrayList<>();

            dfs(answer, n, "", 0, 0);

            return answer;
        }

        public void dfs(List<String> answer, int n, String s, int open, int close) {
            if (s.length() == n * 2) {
                answer.add(s);
                return;
            }

            if (open < n) {
                dfs(answer, n, s + "(", open + 1, close);
            }
            if (close < open) {
                dfs(answer, n, s + ")", open, close + 1);
            }
        }
    }
}
