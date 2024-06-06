class programmers숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        while (start < n) {
            int sum = 0;
            for (int i = start; i < n; i++) {
                sum += i;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
            start++;
        }
        return answer + 1;
    }
}