import java.util.*;

public class programmers3차파일명정렬 {
    class Solution {
        public String[] solution(String[] files) {
            Arrays.sort(files, (s1, s2) -> {
                String head1 = s1.split("\\d")[0].toLowerCase(); // Head는 무조건 첫 숫자의 앞까지 \\d(숫자)
                String number1 = s1.split("\\D+")[1].toLowerCase(); // Number는 \\D(문자)를 기준으로 split

                String head2 = s2.split("\\d")[0].toLowerCase();
                String number2 = s2.split("\\D+")[1].toLowerCase();

                if (!head1.equals(head2)) {
                    return head1.compareTo(head2);
                } else if (Integer.parseInt(number1) != Integer.parseInt(number2)) {
                    return Integer.parseInt(number1) - Integer.parseInt(number2);
                } else {
                    return 0;
                }
            });

            return files;
        }
    }
}
