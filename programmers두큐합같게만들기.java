import java.util.*;

public class programmers두큐합같게만들기 {
    /*
     * while문 내부의 종료조건에서
     * answer > queue1.length * 2 로 하니까 1번 테케가 틀림
     * 최대횟수 관련해서 질문목록에 여러글이 있는데 다 말이 다르네
     * 잘 모르겠다
     */
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int answer = 0;
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            long sum1 = 0;
            long sum2 = 0;
            for (int i = 0; i < queue1.length; i++) {
                q1.offer(queue1[i]);
                q2.offer(queue2[i]);
                sum1 += queue1[i];
                sum2 += queue2[i];
            }

            boolean fail = false;
            while (sum1 != sum2) {
                if (answer > queue1.length * 2 + 1) {
                    fail = true;
                    break;
                }
                if (sum1 > sum2) {
                    sum1 -= q1.peek();
                    sum2 += q1.peek();
                    q2.offer(q1.poll());
                } else {
                    sum1 += q2.peek();
                    sum2 -= q2.peek();
                    q1.offer(q2.poll());
                }
                answer++;
            }

            return fail ? -1 : answer;
        }
    }
}
