import java.util.*;

public class programmers옹알이2 {
    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            Set<String> set = new HashSet<>();
            StringBuilder sb;
            set.add("aya");
            set.add("ye");
            set.add("woo");
            set.add("ma");

            for (int i = 0; i < babbling.length; i++) {
                String word = babbling[i];
                String lastWord = "";
                sb = new StringBuilder();
                for (int j = 0; j < word.length(); j++) {
                    sb.append(word.charAt(j));
                    if (set.contains(sb.toString()) && !lastWord.equals(sb.toString())) {
                        lastWord = sb.toString();
                        sb.delete(0, sb.length());
                    }
                }
                if (sb.length() == 0) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
