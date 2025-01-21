public class programmersLv2소수찾기 {
    class Solution {
        boolean[] visit;
        boolean[] index;
        int answer;
        int length;

        public int solution(String numbers) {
            answer = 0;
            index = new boolean[numbers.length()];
            visit = new boolean[10000000];
            length = numbers.length();
            dfs(numbers, "", 0);

            return answer;
        }

        public void dfs(String numbers, String s, int depth) {
            if (depth > 0) {
                int num = Integer.parseInt(s);
                if (!visit[num] && check(num)) {
                    visit[num] = true;
                    answer++;
                }
            }

            if (depth > length) {
                return;
            }

            for (int i = 0; i < numbers.length(); i++) {
                if (!index[i]) {
                    index[i] = true;
                    dfs(numbers, s + numbers.charAt(i), depth + 1);
                    index[i] = false;
                }
            }
        }

        public boolean check(int num) {
            if (num == 1 || num == 0) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
