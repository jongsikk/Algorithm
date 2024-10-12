import java.util.*;

public class programmers신고결과받기 {

    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int userCount = id_list.length;
            int[] answer = new int[userCount];
            Map<String, Integer> idMap = new HashMap<>();
            boolean[][] reported = new boolean[userCount][userCount];
            boolean[] banned = new boolean[userCount];
            int[] count = new int[userCount];

            for (int i = 0; i < userCount; i++) {
                idMap.put(id_list[i], i);
            }

            for (int i = 0; i < report.length; i++) {
                String[] names = report[i].split(" ");
                int id1 = idMap.get(names[0]);
                int id2 = idMap.get(names[1]);
                if (!reported[id1][id2]) {
                    reported[id1][id2] = true;
                    count[id2]++;
                    if (count[id2] >= k) {
                        banned[id2] = true;
                    }
                }
            }

            for (int i = 0; i < userCount; i++) {
                for (int j = 0; j < userCount; j++) {
                    if (reported[i][j] && banned[j]) {
                        answer[i]++;
                    }
                }
            }

            return answer;
        }
    }
}
