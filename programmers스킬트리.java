public class programmers스킬트리 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            char[] tree = new char[26];
            boolean[] acquired;
            for (int i = 1; i < skill.length(); i++) {
                tree[skill.charAt(i) - 65] = skill.charAt(i - 1);
            }

            for (int i = 0; i < skill_trees.length; i++) {
                String s = skill_trees[i];
                boolean flag = true;
                acquired = new boolean[26];

                for (int j = 0; j < s.length(); j++) {
                    char now = s.charAt(j);
                    if (tree[now - 65] == 0 || acquired[tree[now - 65] - 65]) {
                        acquired[now - 65] = true;
                        continue;
                    }
                    if (!acquired[tree[now - 65] - 65]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
