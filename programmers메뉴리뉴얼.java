import java.util.*;

public class programmers메뉴리뉴얼 {
    class Solution {
        List<Map<String, Integer>> map;

        public String[] solution(String[] orders, int[] course) {
            List<String> answer = new ArrayList<>();
            map = new ArrayList<>();
            for (int i = 0; i <= 10; i++) {
                map.add(new HashMap<>());
            }
            for (String s : orders) {
                for (int i = 0; i < course.length; i++) {
                    char[] c = s.toCharArray();
                    if (c.length >= course[i]) {
                        Arrays.sort(c);
                        dfs(c, 0, course[i], "", new boolean[c.length]);
                    }
                }
            }

            for (int i = 0; i < course.length; i++) {
                int max = -1;
                for (String key : map.get(course[i]).keySet()) {
                    max = Math.max(max, map.get(course[i]).get(key));
                }
                for (String key : map.get(course[i]).keySet()) {
                    if (max >= 2 && map.get(course[i]).get(key) == max) {
                        answer.add(key);
                    }
                }
            }

            Collections.sort(answer);

            return answer.toArray(String[]::new);
        }

        public void dfs(char[] cString, int index, int length, String st, boolean[] visit) {
            if (st.length() == length) {
                map.get(length).put(st, map.get(length).getOrDefault(st, 0) + 1);
                return;
            }

            for (int i = index; i < cString.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(cString, i + 1, length, st + cString[i], visit);
                    visit[i] = false;
                }
            }
        }
    }
}
