public class leetcode853 {
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int answer = 0;
            double[] time = new double[target];
            for (int i = 0; i < position.length; i++) {
                time[position[i]] = (double) (target - position[i]) / speed[i];
            }

            double prev = 0.0;
            for (int i = target - 1; i >= 0; i--) {
                double cur = time[i];
                if (cur > prev) {
                    answer++;
                    prev = cur;
                }
            }

            return answer;
        }
    }
}
