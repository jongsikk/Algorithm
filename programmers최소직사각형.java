public class programmers최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            int width = 0;
            int height = 0;

            for (int i = 0; i < sizes.length; i++) {
                int w = sizes[i][0];
                int h = sizes[i][1];
                if (w < h) {
                    int temp = w;
                    w = h;
                    h = temp;
                }
                width = Math.max(w, width);
                height = Math.max(h, height);
            }

            return width * height;
        }
    }
}
