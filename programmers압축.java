import java.util.*;

public class programmers압축 {
    class Solution {
        public int[] solution(String msg) {
            List<Integer> answer = new ArrayList<>();
            Map<String, Integer> dict = new HashMap<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                dict.put(c + "", c - 64);
            }

            int slice = 0;
            int index = 27;
            while (slice < msg.length()) {
                String word = "";
                int length = 0;
                while (slice + length < msg.length() && dict.containsKey(word + msg.charAt(slice + length))) {
                    word += msg.charAt(slice + length);
                    length++;
                }

                answer.add(dict.get(word));

                if (slice + length < msg.length()) {
                    dict.put(word + msg.charAt(slice + length), index++);
                }

                slice += length;
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
