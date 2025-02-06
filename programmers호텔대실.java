import java.util.*;

public class programmers호텔대실 {
    class Solution {
        public int solution(String[][] book_time) {
            int answer = 1;
            Queue<Integer> q = new LinkedList<>();
            int[][] time = new int[book_time.length][2];
            for (int i = 0; i < book_time.length; i++) {
                int sh = Integer.parseInt(book_time[i][0].split(":")[0]);
                int sm = Integer.parseInt(book_time[i][0].split(":")[1]);
                int eh = Integer.parseInt(book_time[i][1].split(":")[0]);
                int em = Integer.parseInt(book_time[i][1].split(":")[1]);

                time[i][0] = sh * 60 + sm;
                time[i][1] = eh * 60 + em + 10;
            }

            Arrays.sort(time, (t1, t2) -> {
                return t1[0] - t2[0];
            });

            for (int i = 0; i < time.length; i++) {
                for (int j = 0; j < q.size(); j++) {
                    int endTime = q.poll();
                    if (time[i][0] < endTime) {
                        q.offer(endTime);
                    } else {
                        break;
                    }
                }
                q.offer(time[i][1]);
                answer = Math.max(q.size(), answer);
            }

            return answer;
        }
    }
}
