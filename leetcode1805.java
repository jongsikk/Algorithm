import java.util.*;

public class leetcode1805 {
    class Solution {
        public int numDifferentIntegers(String word) {
            Set<String> set = new HashSet<>();
            String[] words = word.replaceAll("[a-z]", " ").trim().split("[\s]+");

            for (String s : words) {
                if (s.length() > 0) {
                    while (s.length() > 1 && s.startsWith("0")) {
                        s = s.substring(1, s.length());
                    }

                    set.add(s);
                }
            }

            return set.size();
        }
    }
}
