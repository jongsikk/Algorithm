import java.util.*;

public class programmers붕대감기 {

    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int lastAttack = attacks[attacks.length - 1][0];
            int maxHealth = health;
            Map<Integer, Integer> attackMap = new HashMap<>();
            for (int i = 0; i < attacks.length; i++) {
                attackMap.put(attacks[i][0], attacks[i][1]);
            }

            int count = 0;
            for (int i = 1; i <= lastAttack; i++) {
                if (attackMap.get(i) != null) {
                    health -= attackMap.get(i);
                    count = 0;
                } else if (health != maxHealth) {
                    health += bandage[1];
                    count++;
                    if (count == bandage[0]) {
                        health += bandage[2];
                        count = 0;
                    }
                    if (health > maxHealth) {
                        health = maxHealth;
                    }
                }
                if (health <= 0) {
                    break;
                }
            }

            return health <= 0 ? -1 : health;
        }
    }
}
