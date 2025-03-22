import java.util.*;

public class programmers중앙값구하기 {
    class Solution {
        public int solution(int[] array) {
            Arrays.sort(array);

            return array[array.length / 2];
        }
    }
}
