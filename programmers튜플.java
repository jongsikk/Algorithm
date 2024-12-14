import java.util.*;

public class programmers튜플 {
    class Solution {
        /*
         * 문제 이해하는데 시간이 더 걸린듯
         * 튜플이 (2, 1, 3, 4)인 경우
         * 1. {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
         * 2. {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
         * 이런식으로 여러가지로 표현이 가능한데,
         * 원소가 2개 이상일 경우에는 순서가 바뀌어도 상관이 없는것같다.
         * 2번의 경우에 원소가 1개짜리 {2} 가 나오기 때문에 맨앞은 2로 시작
         * 그다음 {2, 1} 이니까 2->1
         * 그다음 {1, 2, 3} 이니까 앞에서 했던 2->1 다음에 3
         * 그다음 {1, 2, 4, 3} 에서는 2->1->3->4가 됨
         * 그래서 집합을 크기순으로 오름차순 정렬하고
         * 중복이 없다고 조건이 있기때문에 set 안써도 되지만 그냥써봄
         * 순서가 있으니까 LinkedHashSet 사용
         */
        public int[] solution(String s) {
            String[] tString = s.replaceAll("\\{", " ").replaceAll("\\}", " ").trim().split(" , ");
            Arrays.sort(tString, (s1, s2) -> s1.length() - s2.length());

            Set<String> tuples = new LinkedHashSet<>();
            for (String tuple : tString) {
                String[] nums = tuple.split(",");
                for (String num : nums) {
                    tuples.add(num);
                }
            }

            return tuples.stream().mapToInt(Integer::parseInt).toArray();
        }
    }
}
