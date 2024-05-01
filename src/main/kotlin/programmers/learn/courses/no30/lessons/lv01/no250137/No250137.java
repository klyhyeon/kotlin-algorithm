package programmers.learn.courses.no30.lessons.lv01.no250137;

/* * [PCCP 기출문제] 1번 / 붕대 감기
 * - 성공
 * */
public class No250137 {

    public int solution(int[] bandage, int health, int[][] attacks) {
        // t초 동안 붕대감기, 1초마다 x만큼 체력 회복, t초 연속 성공 시 y만큼 추가 체력 회복
        // max 회복 가능 체력 존재
        /*
        1. 첫 공격을 받고 종료되었을 때 [체력 -= 데미지]
        2. 다음 공격까지 시간을 계산. [체력 += 시간 * x], if (붕대 감은 시간 >= t초) 체력 += y
         */
        int leftHealth = health;
        int time = bandage[0];
        int potion = bandage[1];
        int bonus = bandage[2];
        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];
            leftHealth -= damage;
            if (leftHealth <= 0) {
                leftHealth = -1;
                break;
            }
            if (i == (attacks.length - 1)) {
                break;
            }
            int nextAttackTime = attacks[i + 1][0];
            int bandageTime = nextAttackTime - attackTime - 1;
            leftHealth += (bandageTime * potion);
            if ((bandageTime / (double) time) >= 1) { // TODO why (7 / 5) > 1 is false
                leftHealth += (bandageTime / time) * bonus;
            }
            leftHealth = Math.min(health, leftHealth);
        }
        return leftHealth;
    }
}

class Main {

    public static void main(String[] args) {
        System.out.println(new No250137().solution(
                        new int[]{4, 2, 7},
                        5,
                        new int[][]{{1, 15}, {5, 16}, {8, 6}}
                )
                /*
                [1, 1, 1]	5	[[1, 2], [3, 2]]
                [4, 2, 7]	20	[[1, 15], [5, 16], [8, 6]]
                 */
        );
    }
}
