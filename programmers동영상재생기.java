class Solution {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = stringToInt(video_len);
        int now = stringToInt(pos);
        int op_s = stringToInt(op_start);
        int op_e = stringToInt(op_end);

        for (String c : commands) {
            if (now >= op_s && now <= op_e) {
                now = op_e;
            }
            if ("prev".equals(c)) {
                now = now < 10 ? 0 : now - 10;
            } else {
                now = now + 10 > len ? len : now + 10;
            }
        }

        if (now >= op_s && now <= op_e) {
            now = op_e;
        }

        return intToString(now);
    }

    static int stringToInt(String s) {
        String[] ms = s.split(":");
        int min = Integer.parseInt(ms[0]) * 60;
        int sec = Integer.parseInt(ms[1]);

        return min + sec;
    }

    static String intToString(int n) {
        String min = n / 60 < 10 ? "0" + n / 60 : n / 60 + "";
        String sec = n % 60 < 10 ? "0" + n % 60 : n % 60 + "";

        return min + ":" + sec;
    }
}
