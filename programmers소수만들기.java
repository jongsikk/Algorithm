public class programmers소수만들기 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int sum = nums[i] + nums[j] + nums[k];
                        boolean flag = true;
                        for (int l = 1; l <= sum; l++) {
                            if (sum % l == 0 && l != 1 && l != sum) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
