public class programmers비밀지도 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < arr1.length; i++) {
                String s = Integer.toBinaryString(arr1[i] | arr2[i]);
                if (s.length() < n) {
                    while (s.length() != n) {
                        s = " " + s;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) == '1') {
                        sb.append("#");
                    } else {
                        sb.append(" ");
                    }
                }
                answer[i] = sb.toString();
                sb.delete(0, n);
            }

            return answer;
        }
    }
}
