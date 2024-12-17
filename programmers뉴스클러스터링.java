import java.util.*;

public class programmers뉴스클러스터링 {
    class Solution {
        public int solution(String str1, String str2) {
            if (str1.toLowerCase().equals(str2.toLowerCase())) {
                return 65536;
            }

            int answer = 0;
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            for (int i = 0; i < str1.length() - 1; i++) {
                String sub = str1.substring(i, i + 2).toLowerCase();
                boolean flag = true;
                for (int j = 0; j < 2; j++) {
                    if (!Character.isAlphabetic(sub.charAt(j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list1.add(sub);
                }
            }
            for (int i = 0; i < str2.length() - 1; i++) {
                String sub = str2.substring(i, i + 2).toLowerCase();
                boolean flag = true;
                for (int j = 0; j < 2; j++) {
                    if (!Character.isAlphabetic(sub.charAt(j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list2.add(sub);
                }
            }

            for (int i = 0; i < list1.size(); i++) {
                if (list2.contains(list1.get(i))) {
                    list2.remove(list1.get(i));
                    answer++;
                }
            }

            if (answer == 0) {
                return 0;
            }
            return answer * 65536 / (list1.size() + list2.size());
        }
    }
}
