class programmers다음큰수 {
    public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1')
                count++;
        }
        while (answer != count) {
            answer = 0;
            n++;
            binary = Integer.toBinaryString(n);
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1')
                    answer++;
            }
        }
        return n;
    }
}
