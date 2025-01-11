public class programmers2개이하로다른비트 {
    class Solution {
        /*
         * 다른사람이 적어놓은 힌트를 보고 풀었다.
         * 짝수인 경우에는 ex) 2 -> 10, 4 -> 100, 6 -> 110 이기 때문에 + 1을 해주면 조건을 충족한다.
         * 홀수인 경우에는 ex) 1 -> 01, 3 -> 011, 5 -> 101 이기 때문에
         * 마지막에 나오는 01을 10으로 바꿔주면 조건을 충족한다고 한다.
         * ex) 1 -> 01 -> 10 (2), 3 -> 011 -> 101 (5), 5 -> 101 -> 110 (6)
         */
        public long[] solution(long[] numbers) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    numbers[i] = numbers[i] + 1;
                    continue;
                }

                String start = "0" + Long.toString(numbers[i], 2);
                int index = start.lastIndexOf("01");
                char[] s = start.toCharArray();
                s[index] = '1';
                s[index + 1] = '0';
                numbers[i] = Long.parseLong(new String(s), 2);
            }

            return numbers;
        }
    }
}
