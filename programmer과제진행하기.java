import java.util.*;

public class programmer과제진행하기 {
    class Solution {
        public String[] solution(String[][] plans) {
            List<String> answer = new ArrayList<>();
            Arrays.sort(plans, (p1, p2) -> {
                return timeToInt(p1[1]) - timeToInt(p2[1]);
            });
            Stack<String[]> stack = new Stack<>();

            int time = 0;
            for (int i = 0; i < plans.length; i++) {
                int start = timeToInt(plans[i][1]);
                int playTime = Integer.parseInt(plans[i][2]);
                while (!stack.isEmpty() && time + Integer.parseInt(stack.peek()[1]) <= start) {
                    answer.add(stack.peek()[0]);
                    time += Integer.parseInt(stack.peek()[1]);
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    stack.push(new String[] { plans[i][0], plans[i][2] });
                    time = start;
                } else if (time + Integer.parseInt(stack.peek()[1]) > start) {
                    stack.peek()[1] = (Integer.parseInt(stack.peek()[1]) - (start - time)) + "";

                    stack.push(new String[] { plans[i][0], plans[i][2] });
                    time = start;
                }
            }

            while (!stack.isEmpty()) {
                time += Integer.parseInt(stack.peek()[1]);
                answer.add(stack.pop()[0]);
            }

            return answer.toArray(String[]::new);
        }

        public int timeToInt(String time) {
            String h = time.split(":")[0];
            String m = time.split(":")[1];
            return Integer.parseInt(h) * 60 + Integer.parseInt(m);
        }
    }
}
