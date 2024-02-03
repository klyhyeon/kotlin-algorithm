package programmers.learn.courses.no30.lessons.lv01.no160586

import kotlin.math.min

/* * 대충 만든 자판
* - 실패 후 조건 변경 후 성공
* */
class No160586 {

    fun solution(keymap: Array<String>, targets: Array<String>): List<Int> {
        val answer = mutableListOf<Int>()
        targets.forEach { target ->
            var flag = false
            var sum = 0
            var min: Int
            target.forEach { char ->
                min = Int.MAX_VALUE
                keymap.forEach { key ->
                    val keyIndex = key.indexOf(char)
                    if (keyIndex != -1) {
                        min = min(min, keyIndex)
                    }
                }
                if (min == Int.MAX_VALUE && !flag) {
                    answer.add(-1)
                    flag = true
                } else {
                    sum += (min + 1)
                }
            }
            if (!flag) answer.add(sum)
            flag = false
        }
        return answer
    }
}

fun main() {
    println(
        No160586().solution(
            keymap = arrayOf("AGZ", "BSSS"),
            targets = arrayOf("ASA", "BGZ"),
        )
    )
}