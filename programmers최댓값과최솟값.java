import java.util.*;

public class programmers최댓값과최솟값 {
    class Solution {
        public String solution(String s) {
            int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = Arrays.stream(nums).max().getAsInt();
            int min = Arrays.stream(nums).min().getAsInt();
            return min + " " + max;
        }
    }
}
