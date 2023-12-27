package programmers.learn.courses.no30.lessons.lv01.no131128

import kotlin.math.min

/* * 숫자 짝꿍
* - 실패
* - 다른 사람 풀이보고 성공
* */
class No131128First {

    fun solution(X: String, Y: String): String {
        val list = mutableListOf<String>()
        for (i in 9 downTo 0) {
//            repeat(min(X.count { i.toString() == it.toString() }, Y.count { i.toString() == it.toString() })) { list.add(i.toString()) }
            for (j in 0 until min(X.count { i.toString() == it.toString() }, Y.count { i.toString() == it.toString() })) {
                list.add(i.toString())
            }
        }
        if (list.isEmpty()) return "-1"
        if (list.filterNot { it == "0" }.isEmpty()) return "0"
        return list.joinToString("")
    }
}

fun main() {
    println(No131128First().solution(
        "5525",
        "1255",
    ))
//    val str = "5525"
//    println(str.substring(0, 4))
//    println(str.substring(1, 4))
//    println(str.substring(2, 4))
//    println(str.substring(3, 4))
}