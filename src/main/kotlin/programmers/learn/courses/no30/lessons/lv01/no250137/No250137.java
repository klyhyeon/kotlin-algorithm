package programmers.learn.courses.no30.lessons.lv01.no250137;

public class No250137 {

    public int solution(int[] bandage, int health, int[][] attacks) {
        // t초 동안 붕대감기, 1초마다 x만큼 체력 회복, t초 연속 성공 시 y만큼 추가 체력 회복
        // max 회복 가능 체력 존재
        /*
        1. 첫 공격을 받고 종료되었을 때 [체력 -= 데미지]
        2. 다음 공격까지 시간을 계산. [체력 += 시간 * x], if (시간 >= y) 체력 += y
         */
        int answer = 0;
        return answer;
    }
}
