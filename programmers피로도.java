public class programmers피로도 {
    class Solution {
        static boolean[] visit;
        static int answer;

        public int solution(int k, int[][] dungeons) {
            answer = -1;
            visit = new boolean[dungeons.length];
            dfs(k, dungeons, 0);

            return answer;
        }

        static void dfs(int k, int[][] dungeons, int count) {
            answer = Math.max(answer, count);

            for (int i = 0; i < dungeons.length; i++) {
                if (!visit[i] && dungeons[i][0] <= k) {
                    visit[i] = true;
                    dfs(k - dungeons[i][1], dungeons, count + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
