public class leetcode11 {
    class Solution {
        public int maxArea(int[] height) {
            int answer = 0;
            int start = 0;
            int end = height.length - 1;

            while (start < end) {
                answer = Math.max(answer, Math.min(height[start], height[end]) * (end - start));
                if (height[start] > height[end]) {
                    end--;
                } else {
                    start++;
                }
            }

            return answer;
        }
    }
}
