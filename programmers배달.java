import java.util.*;

public class programmers배달 {
    class Solution {
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            boolean[] visit = new boolean[N + 1];
            List<List<int[]>> graph = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < road.length; i++) {
                int s = road[i][0];
                int e = road[i][1];
                int w = road[i][2];
                graph.get(s).add(new int[] { e, w });
                graph.get(e).add(new int[] { s, w });
            }

            Queue<int[]> queue = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);
            queue.add(new int[] { 1, 0 });
            dist[1] = 0;
            while (!queue.isEmpty()) {
                int[] v = queue.poll();
                int to = v[0];
                int weight = v[1];
                for (int[] i : graph.get(to)) {
                    if (dist[i[0]] > i[1] + weight) {
                        dist[i[0]] = i[1] + weight;
                        queue.add(new int[] { i[0], dist[i[0]] });
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                if (dist[i] <= K) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
