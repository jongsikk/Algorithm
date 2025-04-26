public class programmers개미군단 {
    class Solution {
        public int solution(int hp) {
            return (hp / 5) + ((hp % 5) / 3) + ((hp % 5) % 3);
        }
    }
}
