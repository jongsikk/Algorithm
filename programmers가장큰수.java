import java.util.*;

public class programmers가장큰수 {
    class Solution {
        public String solution(int[] numbers) {
            StringBuilder answer = new StringBuilder();
            Queue<String> pq = new PriorityQueue<>((s1, s2) -> {
                return (s2 + s1).compareTo(s1 + s2);
            });
            for (int i = 0; i < numbers.length; i++) {
                pq.offer(numbers[i] + "");
            }
            while (!pq.isEmpty()) {
                answer.append(pq.poll());
            }
            return answer.charAt(0) == '0' ? "0" : answer.toString();
        }
    }
}
