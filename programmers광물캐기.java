public class programmers광물캐기 {
    class Solution {
        int answer;

        public int solution(int[] picks, String[] minerals) {
            answer = Integer.MAX_VALUE;
            dfs(minerals, picks[0], picks[1], picks[2], 0, 0);

            return answer;
        }

        public void dfs(String[] minerals, int dia, int iron, int stone, int index, int weight) {
            if (minerals.length <= index || (dia == 0 && iron == 0 && stone == 0)) {
                answer = Math.min(answer, weight);
                return;
            }

            int len = Math.min(minerals.length, index + 5);

            if (dia != 0) {
                dfs(minerals, dia - 1, iron, stone, len, weight + len - index);
            }
            if (iron != 0) {
                int sum = 0;
                for (int i = index; i < len; i++) {
                    if ("diamond".equals(minerals[i])) {
                        sum += 5;
                    } else {
                        sum++;
                    }
                }
                dfs(minerals, dia, iron - 1, stone, len, weight + sum);
            }
            if (stone != 0) {
                int sum = 0;
                for (int i = index; i < len; i++) {
                    if ("diamond".equals(minerals[i])) {
                        sum += 25;
                    } else if ("iron".equals(minerals[i])) {
                        sum += 5;
                    } else {
                        sum++;
                    }
                }
                dfs(minerals, dia, iron, stone - 1, len, weight + sum);
            }

        }
    }
}
