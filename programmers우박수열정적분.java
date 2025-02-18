import java.util.*;

public class programmers우박수열정적분 {
    class Solution {
        public double[] solution(int k, int[][] ranges) {
            double[] answer = new double[ranges.length];
            List<int[]> graph = new ArrayList<>();
            int n = 0;
            while (k != 1) {
                graph.add(new int[] { n++, k });
                if (k % 2 == 0) {
                    k /= 2;
                } else {
                    k = (k * 3) + 1;
                }
            }
            graph.add(new int[] { n++, k });

            for (int i = 0; i < ranges.length; i++) {
                double sum = 0;
                int from = ranges[i][0];
                int to = ranges[i][1] == 0 ? graph.size() - 1 : graph.size() + ranges[i][1] - 1;
                if (from > to) {
                    answer[i] = -1;
                    continue;
                }
                for (int j = from; j < to; j++) {
                    sum += ((double) graph.get(j)[1] + graph.get(j + 1)[1]) / 2;
                }
                answer[i] = sum;
            }

            return answer;
        }
    }
}
