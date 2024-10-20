import java.util.*;

public class programmers크레인인형뽑기게임 {
    // [0,0,0,0,0]
    // [0,0,0,0,0],
    // [0,0,5,0,0],
    // [0,2,4,0,2],
    // [0,5,1,3,1] [1,5,3,5,1,2,1,4]
    // stack {4, 3, 1, 1, 3, 2, 4};
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < moves.length; i++) {
                int line = moves[i];
                int pick = 0;
                for (int j = 0; j < board.length; j++) {
                    if (board[j][line - 1] != 0) {
                        pick = board[j][line - 1];
                        board[j][line - 1] = 0;
                        break;
                    }
                }
                if (stack.size() > 0 && pick != 0 && pick == stack.peek()) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(pick);
                }
            }
            return answer;
        }
    }
}
