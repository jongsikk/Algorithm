public class programmers가위바위보 {
    class Solution {
        public String solution(String rsp) {
            StringBuffer answer = new StringBuffer();
            for (char a : rsp.toCharArray()) {
                switch (a) {
                    case '2':
                        answer.append('0');
                        break;
                    case '0':
                        answer.append('5');
                        break;
                    case '5':
                        answer.append('2');
                        break;
                }
            }

            return answer.toString();
        }
    }
}
