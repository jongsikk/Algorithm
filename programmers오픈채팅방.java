import java.util.*;

public class programmers오픈채팅방 {
    class Solution {
        public String[] solution(String[] record) {
            String[] answer = {};
            Map<String, String> idMap = new HashMap<>();
            List<String[]> logs = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < record.length; i++) {
                String[] s = record[i].split(" ");
                if ("Enter".equals(s[0])) {
                    idMap.put(s[1], s[2]);
                    logs.add(new String[] { s[1], "IN" });
                } else if ("Leave".equals(s[0])) {
                    logs.add(new String[] { s[1], "OUT" });
                } else if ("Change".equals(s[0])) {
                    idMap.put(s[1], s[2]);
                }
            }

            answer = new String[logs.size()];
            for (int i = 0; i < logs.size(); i++) {
                String[] log = logs.get(i);
                sb.append(idMap.get(log[0]) + "님이 ");
                if ("IN".equals(log[1])) {
                    sb.append("들어왔습니다.");
                } else {
                    sb.append("나갔습니다.");
                }
                answer[i] = sb.toString();
                sb.delete(0, sb.length());
            }

            return answer;
        }

        public String[] solution2(String[] record) {
            Map<String, String> idMap = new HashMap<>();
            List<String> logs = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < record.length; i++) {
                String[] s = record[i].split(" ");
                if ("Enter".equals(s[0])) {
                    idMap.put(s[1], s[2]);
                } else if ("Change".equals(s[0])) {
                    idMap.put(s[1], s[2]);
                }
            }

            for (int i = 0; i < record.length; i++) {
                String[] s = record[i].split(" ");
                if ("Enter".equals(s[0])) {
                    logs.add(idMap.get(s[1]) + "님이 들어왔습니다.");
                } else if ("Leave".equals(s[0])) {
                    logs.add(idMap.get(s[1]) + "님이 나갔습니다.");
                }
            }
            return logs.stream().toArray(String[]::new);
        }
    }

}
