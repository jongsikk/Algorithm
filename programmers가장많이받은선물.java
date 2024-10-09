import java.util.*;

public class programmers가장많이받은선물 {
    class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            Map<String, Integer> names = new HashMap<>();
            List<int[]> table = new ArrayList<>();
            List<int[]> counts = new ArrayList<>(); // {give, take}
            int[] exp = new int[friends.length];

            for (int i = 0; i < friends.length; i++) {
                names.put(friends[i], i);
            }
            for (int i = 0; i < friends.length; i++) {
                table.add(new int[friends.length]);
                counts.add(new int[2]);
            }

            for (int i = 0; i < gifts.length; i++) {
                String[] name = gifts[i].split(" ");
                table.get(names.get(name[0]))[names.get(name[1])]++;
                counts.get(names.get(name[0]))[0]++;
                counts.get(names.get(name[1]))[1]++;
            }

            for (int i = 0; i < friends.length; i++) {
                for (int j = i + 1; j < friends.length; j++) {
                    System.out.println(i + " " + j + " " + table.get(i)[j] + " " + table.get(j)[i]);
                    if (table.get(i)[j] > table.get(j)[i]) {
                        exp[i]++;
                    } else if (table.get(i)[j] < table.get(j)[i]) {
                        exp[j]++;
                    } else {
                        int aIndex = counts.get(i)[0] - counts.get(i)[1];
                        int bIndex = counts.get(j)[0] - counts.get(j)[1];
                        if (aIndex > bIndex) {
                            exp[i]++;
                        } else if (aIndex < bIndex) {
                            exp[j]++;
                        }
                    }
                }
            }

            for (int i = 0; i < friends.length; i++) {
                answer = Math.max(answer, exp[i]);
            }

            return answer;
        }
    }
}
