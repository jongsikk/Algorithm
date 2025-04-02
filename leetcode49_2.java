import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode49_2 {
    /*
     * 풀었던 문제인데 또 풀어버렸다
     */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String newString = new String(array);
                if (map.containsKey(newString)) {
                    map.get(newString).add(str);
                } else {
                    map.put(newString, new ArrayList<>(Arrays.asList(str)));
                }
            }

            return new ArrayList<>(map.values());
        }
    }
}
