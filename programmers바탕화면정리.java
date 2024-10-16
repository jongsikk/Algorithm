public class programmers바탕화면정리 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];
            int xmin = Integer.MAX_VALUE;
            int ymin = Integer.MAX_VALUE;
            int xmax = 0;
            int ymax = 0;

            for (int i = 0; i < wallpaper.length; i++) {
                String line = wallpaper[i];
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == '#') {
                        xmin = Math.min(xmin, i);
                        ymin = Math.min(ymin, j);
                        xmax = Math.max(xmax, i + 1);
                        ymax = Math.max(ymax, j + 1);
                    }
                }
            }

            answer[0] = xmin;
            answer[1] = ymin;
            answer[2] = xmax;
            answer[3] = ymax;

            return answer;
        }
    }
}
