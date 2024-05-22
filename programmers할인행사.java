import java.util.*;

class programmers할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> disMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                if (disMap.containsKey(discount[i + j])) {
                    disMap.put(discount[i + j], disMap.get(discount[i + j]) + 1);
                } else {
                    disMap.put(discount[i + j], 1);
                }
            }

            Boolean check = true;
            for (String key : map.keySet()) {
                if (map.get(key) != disMap.get(key)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
        }
        return answer;
    }
}