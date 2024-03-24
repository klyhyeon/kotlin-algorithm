package programmers.learn.courses.no30.lessons.lv01.no172928

/**
 * 공원 산책
 */
class No172928 {

    /**
     * park: 시작점(S)
     * routes: 동서남북 + 숫자
     * 1. 시작점 좌표(startPoint)를 변수에 저장
     * 2. routes[i]를 차례대로 순회하며 움질일 수 있는 칸이면 startPoint를 변경함
     */
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray
        var dogCurrentPoint: Pair<Int, Int> = Pair(0, 0)
        var maxWidth = park[0].length - 1
        for (i in 0 until park.size - 1) {
            if (park[i] == "S") {
                dogCurrentPoint = Pair(i, park[i].indexOf("S"))
            }
        }
        routes.forEach {
            var splitedValue = it.split(" ")
            var direction = splitedValue[0]
            var distance = splitedValue[1].toInt()
            var tempPoint: Pair<Int, Int> = Pair(0, 0)
            when (direction) {
                "E" -> tempPoint = Pair(dogCurrentPoint.first, dogCurrentPoint.second.plus(distance))
                "W" -> tempPoint = Pair(dogCurrentPoint.first, dogCurrentPoint.second.minus(distance))
                "S" -> tempPoint = Pair(dogCurrentPoint.first.plus(distance), dogCurrentPoint.second)
                "N" -> tempPoint = Pair(dogCurrentPoint.first.minus(distance), dogCurrentPoint.second)
            }
            if (tempPoint.first < park.size || tempPoint.first >= 0 ||
                tempPoint.second <= maxWidth || tempPoint.second >= 0 ||
                park[tempPoint.first].get(tempPoint.second) != 'X'
            ) {
                dogCurrentPoint = tempPoint
            }
        }
        answer = intArrayOf(dogCurrentPoint.first, dogCurrentPoint.second)
        return answer
    }
}


fun main() {
    No172928().solution(
        park = arrayOf("SOO","OXX","OOO"),
        routes = arrayOf("E 2","S 2","W 1"),
    ).forEach { println(it) }
}