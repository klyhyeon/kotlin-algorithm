package programmers.learn.courses.no30.lessons.lv01.no133499

/* * 옹알이 (2)
* - 실패
* - 블로그 풀이
* */
class No133499 {
    fun solution(babbling: Array<String>): Int {
        var answer = 0
        val answerWordRegex = Regex("aya|ye|woo|ma")
        babbling.forEach {
            if (it.replace(answerWordRegex, "").isEmpty()) {
                if (!(it.contains("ayaaya") || it.contains("yeye") || it.contains("woowoo") || it.contains("mama"))) {
                    answer += 1
                }
            }
        }
        return answer
    }

}

fun main() {
    val babbling = arrayOf("aya", "yee", "u", "maa")
    println(No133499().solution(babbling))
}