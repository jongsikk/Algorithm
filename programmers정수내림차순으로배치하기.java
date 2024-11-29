import java.util.*;

public class programmers정수내림차순으로배치하기 {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            List<String> list = new ArrayList<>();
            while (n > 0) {
                list.add((n % 10) + "");
                n /= 10;
            }

            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                answer += Long.parseLong(list.get(i)) * Math.pow(10, i);
            }

            return answer;
        }
    }
}
