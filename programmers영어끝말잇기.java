import java.util.*;

public class programmers영어끝말잇기 {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            Set<String> set = new HashSet<>();
            char last = words[0].charAt(0);

            for (int i = 0; i < words.length; i++) {
                if (words[i].charAt(0) == last && !set.contains(words[i])) {
                    last = words[i].charAt(words[i].length() - 1);
                    set.add(words[i]);
                } else {
                    System.out.println(last + " " + words[i]);
                    answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                    answer[1] = i / n + 1;
                    break;
                }
            }

            return answer;
        }
    }
}
