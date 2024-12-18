public class programmers타겟넘버 {
    class Solution {
        static int answer;

        public int solution(int[] numbers, int target) {
            answer = 0;
            dfs(numbers, 0, 0, target);
            return answer;
        }

        static void dfs(int[] numbers, int sum, int index, int target) {
            if (index == numbers.length) {
                if (sum == target) {
                    answer++;
                    return;
                }
            }
            if (index < numbers.length) {
                dfs(numbers, sum + numbers[index], index + 1, target);
                dfs(numbers, sum - numbers[index], index + 1, target);
            }
        }
    }
}
