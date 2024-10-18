import java.util.*;

public class programmers성격유형검사하기 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            StringBuilder sb = new StringBuilder();
            int[] count = new int[4];
            for (int i = 0; i < survey.length; i++) {
                if (survey[i].equals("RT")) {
                    count[0] += choices[i] - 4;
                }
                if (survey[i].equals("CF")) {
                    count[1] += choices[i] - 4;
                }
                if (survey[i].equals("JM")) {
                    count[2] += choices[i] - 4;
                }
                if (survey[i].equals("AN")) {
                    count[3] += choices[i] - 4;
                }
                if (survey[i].equals("TR")) {
                    count[0] -= choices[i] - 4;
                }
                if (survey[i].equals("FC")) {
                    count[1] -= choices[i] - 4;
                }
                if (survey[i].equals("MJ")) {
                    count[2] -= choices[i] - 4;
                }
                if (survey[i].equals("NA")) {
                    count[3] -= choices[i] - 4;
                }
            }

            if (count[0] <= 0) {
                sb.append("R");
            } else {
                sb.append("T");
            }
            if (count[1] <= 0) {
                sb.append("C");
            } else {
                sb.append("F");
            }
            if (count[2] <= 0) {
                sb.append("J");
            } else {
                sb.append("M");
            }
            if (count[3] <= 0) {
                sb.append("A");
            } else {
                sb.append("N");
            }

            return sb.toString();
        }
    }
}
