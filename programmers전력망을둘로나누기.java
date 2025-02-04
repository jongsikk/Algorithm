import java.util.*;

public class programmers전력망을둘로나누기 {
    class Solution {
        public List<List<Integer>> nodes;
        public boolean[] visit;

        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            nodes = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < wires.length; i++) {
                int n1 = wires[i][0];
                int n2 = wires[i][1];

                nodes.get(n1).add(n2);
                nodes.get(n2).add(n1);
            }

            for (int i = 1; i < n + 1; i++) {
                List<Integer> iEdges = nodes.get(i);
                for (int e : iEdges) {
                    int cnt1 = bfs(i, e, n);
                    int cnt2 = bfs(e, i, n);

                    answer = Math.min(answer, Math.abs(cnt1 - cnt2));
                }
            }

            return answer;
        }

        public int bfs(int start, int exclude, int n) {
            int count = 0;
            Queue<Integer> q = new LinkedList<>();
            visit = new boolean[n + 1];
            q.offer(start);
            visit[start] = true;
            while (!q.isEmpty()) {
                int s = q.poll();
                for (int i : nodes.get(s)) {
                    if (i != exclude && !visit[i]) {
                        visit[i] = true;
                        count++;
                        q.offer(i);
                    }
                }
            }

            return count;
        }
    }
}
