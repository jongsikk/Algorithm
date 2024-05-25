class programmersJadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        answer += (s.charAt(0) + "").toUpperCase();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ') {
                answer += (s.charAt(i + 1) + "").toUpperCase();
            } else {
                answer += (s.charAt(i + 1) + "");
            }
        }

        return answer;
    }
}