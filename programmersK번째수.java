import java.util.*;

public class programmersK번째수 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for (int i = 0; i < commands.length; i++) {
                int[] newArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
                Arrays.sort(newArray);
                answer[i] = newArray[commands[i][2] - 1];
            }

            return answer;
        }
    }
}
