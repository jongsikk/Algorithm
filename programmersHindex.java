import java.util.*;

public class programmersHindex {
    class Solution {
        /*
         * H-Index는 내림차순으로 정렬하여
         * 인용 횟수가 해당 index와 일치하거나 초과할 때 h-index
         * index 4, 값 1 일 경우 index가 더 크기때문에 성립 X
         * 1 6
         * 2 5
         * 3 3 <--
         * 4 1
         * 5 0
         */
        public int solution(int[] citations) {
            int answer = 0;
            Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);
            Arrays.sort(c, Collections.reverseOrder());
            for (int i = 0; i < c.length; i++) {
                if (i + 1 <= c[i]) {
                    answer = i + 1;
                }
            }

            return answer;
        }
    }
}
