package programmers.learn.courses.no30.lessons.lv01.no131128

import kotlin.math.min

/* * 숫자 짝꿍
* - 실패
* - 다른 사람 풀이보고 성공
* - String으로 직접 +=를 쓰면 String을 계속해서 생산해내기 때문에 시간초과가 뜸
* - StringBuilder나 List를 사용하면 시간이 단축됨
* - 걸리는 시간 빠른순 StringBuilder > List > String(실패)
* */
class No131128Second {

    fun solution(X: String, Y: String): String {
        var answer = StringBuilder()
        for (i in 9 downTo 0) {
//            repeat(min(X.count { i.toString() == it.toString() }, Y.count { i.toString() == it.toString() })) { list.add(i.toString()) }
            for (j in 0 until min(X.count { i.toString() == it.toString() }, Y.count { i.toString() == it.toString() })) {
                answer.append(i.toString())
            }
        }
        if (answer.isEmpty()) return "-1"
        if (answer.filterNot { it == '0' }.isEmpty()) return "0"
        return answer.toString()
    }
}

fun main() {
    println(No131128Second().solution(
        "5525",
        "1255",
    ))
}