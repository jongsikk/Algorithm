public class programmers삼총사 {
    static class Solution {
        static int answer = 0;
        static boolean[] visit;

        public int solution(int[] number) {
            visit = new boolean[number.length];

            dfs(number, 0, 0);

            return answer;
        }

        static void dfs(int[] number, int start, int depth) {
            if (depth == 3) {
                int sum = 0;
                for (int i = 0; i < number.length; i++) {
                    if (visit[i]) {
                        sum += number[i];
                    }
                }
                if (sum == 0) {
                    answer++;
                }
                return;
            }

            for (int i = start; i < number.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(number, i + 1, depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
