import java.util.*;

public class programmers개인정보수집기간 {

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer;
            boolean[] isExpired = new boolean[privacies.length];
            Map<String, Integer> termsMap = new HashMap<>();
            for (int i = 0; i < terms.length; i++) {
                String[] s = terms[i].split(" ");
                termsMap.put(s[0], Integer.parseInt(s[1]));
            }
            String[] t = today.split("\\.");
            int ty = Integer.parseInt(t[0]);
            int tm = Integer.parseInt(t[1]);
            int td = Integer.parseInt(t[2]);
            int count = 0;

            for (int i = 0; i < privacies.length; i++) {
                String term = privacies[i].split(" ")[1];
                String[] date = privacies[i].split(" ")[0].split("\\.");
                int y = Integer.parseInt(date[0]) + termsMap.get(term) / 12;
                int m = Integer.parseInt(date[1]) + termsMap.get(term) % 12;
                int d = Integer.parseInt(date[2]);

                if (m > 12) {
                    y += (m / 12);
                    m %= 12;
                }
                d--;
                if (d < 1) {
                    m--;
                    d = 28;
                    if (m < 1) {
                        y--;
                        m = 12;
                    }
                }

                if (ty == y) {
                    if (tm == m) {
                        if (td > d) {
                            isExpired[i] = true;
                        }
                    } else if (tm > m) {
                        isExpired[i] = true;
                    }
                } else if (ty > y) {
                    isExpired[i] = true;
                }

                if (isExpired[i]) {
                    count++;
                }
            }

            answer = new int[count];
            int index = 0;

            for (int i = 0; i < isExpired.length; i++) {
                if (isExpired[i]) {
                    answer[index++] = i + 1;
                }
            }
            return answer;
        }
    }
}
