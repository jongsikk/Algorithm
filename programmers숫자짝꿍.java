import java.util.*;

public class programmers숫자짝꿍 {
    class Solution {
        public String solution(String X, String Y) {
            StringBuilder sb = new StringBuilder();
            Map<Integer, Integer> xMap = new HashMap<>();
            Map<Integer, Integer> yMap = new HashMap<>();

            for (int i = 0; i < X.length(); i++) {
                xMap.put(X.charAt(i) - '0', xMap.getOrDefault(X.charAt(i) - '0', 0) + 1);
            }
            for (int i = 0; i < Y.length(); i++) {
                yMap.put(Y.charAt(i) - '0', yMap.getOrDefault(Y.charAt(i) - '0', 0) + 1);
            }

            for (int i = 9; i >= 0; i--) {
                int xCount = xMap.getOrDefault(i, 0);
                int yCount = yMap.getOrDefault(i, 0);
                int count = Math.min(xCount, yCount);

                for (int j = 0; j < count; j++) {
                    sb.append(i + "");
                }
            }

            if (sb.length() == 0) {
                return "-1";
            }
            if (sb.charAt(0) == '0') {
                return "0";
            }

            return sb.toString();
        }
    }
}
