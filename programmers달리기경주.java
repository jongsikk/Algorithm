import java.util.*;

public class programmers달리기경주 {

    class Solution {
        public String[] solution(String[] players, String[] callings) {
            String[] answer = new String[players.length];
            Map<String, Integer> rankMap = new HashMap<>();
            for (int i = 0; i < players.length; i++) {
                rankMap.put(players[i], i);
                answer[i] = players[i];
            }

            for (int i = 0; i < callings.length; i++) {
                int nowRank = rankMap.get(callings[i]);
                String front = answer[nowRank - 1];

                answer[nowRank - 1] = answer[nowRank];
                answer[nowRank] = front;
                rankMap.replace(front, nowRank);
                rankMap.replace(answer[nowRank - 1], nowRank - 1);
            }

            return answer;
        }
    }
}
