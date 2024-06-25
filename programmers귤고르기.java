import java.util.*;

class programmers귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        List<Integer> list = new LinkedList<>();
        for (Integer value : map.values()) {
            list.add(value);
        }
        Collections.sort(list, Collections.reverseOrder());
        int sum = 0;
        for (Integer i : list) {
            if (sum + i < k) {
                sum += i;
                answer++;
            } else {
                answer++;
                break;
            }
        }
        return answer;
    }
}