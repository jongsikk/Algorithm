import java.util.*;

public class programmers대충만든자판 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < keymap.length; i++) {
                for (int j = 0; j < keymap[i].length(); j++) {
                    map.put(keymap[i].charAt(j),
                            Math.min(map.getOrDefault(keymap[i].charAt(j), Integer.MAX_VALUE), j + 1));
                }
            }

            for (int i = 0; i < targets.length; i++) {
                int sum = 0;
                boolean flag = true;
                for (int j = 0; j < targets[i].length(); j++) {
                    if (map.containsKey(targets[i].charAt(j))) {
                        sum += map.get(targets[i].charAt(j));
                    } else {
                        flag = false;
                        break;
                    }
                }
                answer[i] = flag ? sum : -1;
            }

            return answer;
        }
    }
}
