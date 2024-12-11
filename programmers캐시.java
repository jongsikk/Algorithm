import java.util.*;

public class programmers캐시 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            if (cacheSize == 0) {
                return cities.length * 5;
            }

            int answer = 0;
            Queue<String> cache = new LinkedList<>();

            for (int i = 0; i < cities.length; i++) {
                String city = cities[i].toLowerCase();
                if (cache.contains(city)) {
                    answer += 1;
                    cache.remove(city);
                } else {
                    answer += 5;
                    if (cache.size() >= cacheSize) {
                        cache.poll();
                    }
                }
                cache.offer(city);
            }

            return answer;
        }
    }
}
