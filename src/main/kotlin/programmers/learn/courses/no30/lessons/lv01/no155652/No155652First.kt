package programmers.learn.courses.no30.lessons.lv01.no155652

/* * 둘만의 암호
* - 실패
* */
class No155652First {
    fun solution(s: String, skip: String, index: Int): String {
        val answerBuilder: StringBuilder = StringBuilder()
        for (i in s.indices) {
            val currentChar = s[i]
            var tempIndex = index
            var tempSkip = ""
            for (j in 1 .. index) {
                var nextChar = currentChar.code + j
                if (nextChar > 122) nextChar -= 26
                tempSkip += nextChar.toChar()
            }
            tempIndex += tempSkip.count { skip.toSet().contains(it) }
//            skip.forEach {
//                for (j in 1 .. index) {
//                    var z = currentChar.code + j
//                    if (z > 122) z -= 26
//                    if (it == z.toChar()) {
//                        tempIndex++
//                    }
//                }
//            }

            if (currentChar.code + tempIndex > 122) {
                answerBuilder.append((currentChar.code + tempIndex - 26).toChar())
                continue
            }
            answerBuilder.append(s[i] + tempIndex)
        }
        return answerBuilder.toString()
    }
}

fun main() {
    println(No155652First().solution("aukks", "wbqd", 5))
//    println(if('z'.code + 5 > 122) println(('z'.code + 5 - 26).toChar()) else println('z'))
}