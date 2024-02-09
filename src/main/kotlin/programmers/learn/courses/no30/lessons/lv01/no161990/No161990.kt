package programmers.learn.courses.no30.lessons.lv01.no161990

/* * 바탕화면 정리
* - 성공
* */
class No161990 {

    // 좌, 우, 상, 하의 최대값을 구하기
    // 배열의 크기 = 열의 갯수
    // 배열 인자의 길이 = 행의 개수
    // 필요한 변수: 좌, 우, 상, 하의 max 값
    // 상, 하 구하는 법은 배열 반복문을 돌며 각 인자가 #를 가지고 있는 min과 max 인자를 뱉으면 됨
    // upDownList
    // for (i : list) { if (min == 0 && i.contains(#)) then upDownList.add(i.index) }
    // 상(luy) = upDownList.min, 하(rdy) = upDownList.max
    // 좌, 우 구하는 법인 배열 인자의 String 반복문을 돌며 인자에서 가장 왼쪽에 가까운 파일의 index와 가장 오른쪽에 가까운 파일의 index를 뱉으면 됨
    // leftRightList
    // for (i : list) { for (j : i) { Math.min(j.first(#), lux) Math.max(j.last(#), rdx) } }
    fun solution(wallpaper: Array<String>): IntArray {
        var answer = IntArray(4)
        val file = '#'
        var luy = Int.MAX_VALUE
        var rdy = Int.MIN_VALUE
        var lux = Int.MAX_VALUE
        var rdx = Int.MIN_VALUE
        for (idx in wallpaper.indices) {
            if (wallpaper[idx].contains(file)) {
                luy = idx.coerceAtMost(luy)
                rdy = idx.coerceAtLeast(rdy)
                lux = wallpaper[idx].indexOfFirst { it == file }.coerceAtMost(lux)
                rdx = wallpaper[idx].indexOfLast { it == file }.coerceAtLeast(rdx)
            }
        }
        answer[0] = luy
        answer[1] = lux
        answer[2] = rdy + 1
        answer[3] = rdx + 1
        return answer
    }

}

fun main() {
    No161990().solution(
        arrayOf("..", "#.")
    ).forEach { println(it) }
}