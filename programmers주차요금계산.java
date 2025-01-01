import java.util.*;

public class programmers주차요금계산 {
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer;
            Map<String, Integer> timeMap = new HashMap<>();
            Map<String, Integer> totalMap = new HashMap<>();
            Map<String, Boolean> inOutMap = new HashMap<>();

            for (int i = 0; i < records.length; i++) {
                String[] infos = records[i].split(" ");
                String[] time = infos[0].split(":");
                int seconds = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                String car = infos[1];
                boolean inOut = "IN".equals(infos[2]); // in = true, out = false
                inOutMap.put(car, inOut);
                if (inOut) {
                    timeMap.put(car, seconds);
                } else {
                    totalMap.put(car, totalMap.getOrDefault(car, 0) + (seconds - timeMap.get(car)));
                }
            }

            // 23:59 기준으로 출차 안한 차량 계산
            for (String car : inOutMap.keySet()) {
                if (inOutMap.get(car)) {
                    totalMap.put(car, totalMap.getOrDefault(car, 0) + (1439 - timeMap.get(car)));
                }
            }

            String[] carNum = totalMap.keySet().toArray(new String[totalMap.size()]);
            Arrays.sort(carNum);
            answer = new int[carNum.length];

            // fees : 기본 시간, 기본 요금, 단위 시간, 단위 요금
            for (int i = 0; i < carNum.length; i++) {
                if (totalMap.get(carNum[i]) <= fees[0]) {
                    answer[i] = fees[1];
                } else {
                    answer[i] = fees[1]
                            + (int) (Math.ceil((totalMap.get((carNum[i])) - fees[0]) / (double) fees[2])) * fees[3];
                }
            }

            return answer;
        }
    }
}
