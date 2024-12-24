public class programmersK진수에서소수개수구하기 {
    class Solution {
        /*
         * 소수 구하는 부분에서 처음에 2 ~ nn까지 구하니까
         * 1번 테스트 케이스에서 시간초과가 났다
         * 에라토스테네스의 체를 사용해서 범위바꿔주니까 통과
         */
        public int solution(int n, int k) {
            int answer = 0;
            if (n == 1) {
                return 0;
            }

            String num = Integer.toString(n, k);
            String[] spl = num.split("0");
            for (String s : spl) {
                if (!s.equals("")) {
                    long nn = Long.parseLong(s);
                    if (nn != 1) {
                        boolean flag = true;
                        for (long i = 2; i <= Math.sqrt(nn); i++) {
                            if (nn % i == 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            answer++;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
