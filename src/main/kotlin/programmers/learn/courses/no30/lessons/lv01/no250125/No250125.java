package programmers.learn.courses.no30.lessons.lv01.no250125;

/* * PCCE 기출 9번 이웃한 칸
 * - 성공
 * */
public class No250125 {

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        for (int i = 0; i < 4; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
            if (hCheck < n && hCheck >= 0 && wCheck < n && wCheck >= 0) {
                if (board[h][w].equals(board[hCheck][wCheck])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
