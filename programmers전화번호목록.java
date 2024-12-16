import java.util.*;

public class programmers전화번호목록 {
    class Solution {
        /*
         * 2번으로 풀었다가 Hash 문제길래 1번으로 다시 풀어봄
         */
        public boolean solution(String[] phone_book) {
            Map<String, String> book = new HashMap<>();
            for (String s : phone_book) {
                book.put(s, s);
            }
            for (int i = 0; i < phone_book.length; i++) {
                for (int j = 0; j < phone_book[i].length(); j++) {
                    if (book.containsKey(phone_book[i].substring(0, j))) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean solution2(String[] phone_book) {
            Arrays.sort(phone_book);
            for (int i = 0; i < phone_book.length - 1; i++) {
                if (phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
            }
            return true;
        }
    }
}
