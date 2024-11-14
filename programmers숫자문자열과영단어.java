import java.util.*;

public class programmers숫자문자열과영단어 {
    class Solution {
        public int solution(String s) {
            Map<String, Integer> map = new HashMap<>();
            StringBuilder answer = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            map.put("zero", 0);
            map.put("one", 1);
            map.put("two", 2);
            map.put("three", 3);
            map.put("four", 4);
            map.put("five", 5);
            map.put("six", 6);
            map.put("seven", 7);
            map.put("eight", 8);
            map.put("nine", 9);

            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    answer.append(s.charAt(i));
                } else {
                    sb.append(s.charAt(i));
                    if (map.containsKey(sb.toString())) {
                        answer.append(map.get(sb.toString()));
                        sb.delete(0, sb.length());
                    }
                }
            }

            return Integer.parseInt(answer.toString());
        }
    }
}
