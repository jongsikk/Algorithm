import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String s : strs) {
                char[] array = s.toCharArray();
                Arrays.sort(array);
                String newString = new String(array);
                if (!map.containsKey(newString)) {
                    map.put(newString, new ArrayList<>());
                }
                map.get(newString).add(s);
            }

            return new ArrayList<>(map.values());
        }
    }
}
