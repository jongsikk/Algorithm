import java.util.*;

public class programmers다리를지나는트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            // weight, time
            Queue<int[]> q = new LinkedList<>();
            int index = 0;
            int total = 0;

            while (!q.isEmpty() || index < truck_weights.length) {
                answer++;
                if (!q.isEmpty() && answer - q.peek()[1] >= bridge_length) {
                    total -= q.peek()[0];
                    q.poll();
                }
                if (index < truck_weights.length && total + truck_weights[index] <= weight) {
                    q.offer(new int[] { truck_weights[index], answer });
                    total += truck_weights[index++];
                }
            }

            return answer;
        }
    }
}
