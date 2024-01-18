package programmers.learn.courses.no30.lessons.lv01.no72410

/* * 2021 KAKAO BLIND RECRUITMENT 신규 아이디 추천
* - 성공
* */
class No72410 {

    fun solution(new_id: String): String {
        var answer: String = ""
        // step 1
        answer = new_id.lowercase()
        // step 2
        answer = answer.replace("[^A-Za-z0-9.\\-_]".toRegex(), "")
        // step 3
        while (answer.contains("..")) {
            answer = answer.replace("..", ".")
        }
        // step 4
        while (answer.startsWith(".")) {
            answer = answer.removePrefix(".")
        }
        while (answer.endsWith(".")) {
            answer = answer.removeSuffix(".")
        }
        // step 5
        if (answer.isEmpty()) answer = "a"
        // step 6
        if (answer.length >= 16) answer = answer.substring(0, 15)
        while (answer.endsWith(".")) {
            answer = answer.removeSuffix(".")
        }
        // step 7
        if (answer.length <= 2) {
            while (answer.length <= 2) {
                answer += answer.last()
            }
        }
        return answer
    }

    // 더 느림
    fun solution2(new_id: String): String {
        var answer: StringBuilder = StringBuilder()
        // step 1
        answer.append(new_id.lowercase())
        // step 2
        answer.replace("[^A-Za-z0-9.\\-_]".toRegex(), "")
        // step 3
        while (answer.contains("..")) {
            answer.replace("..".toRegex(), ".")
        }
        // step 4
        while (answer.startsWith(".")) {
            answer.removePrefix(".")
        }
        while (answer.endsWith(".")) {
            answer.removeSuffix(".")
        }
        // step 5
        if (answer.isEmpty()) answer.append("a")
        // step 6
        if (answer.length >= 16) answer.substring(0, 15)
        while (answer.endsWith(".")) {
            answer.removeSuffix(".")
        }
        // step 7
        if (answer.length <= 2) {
            while (answer.length <= 2) {
                answer.append(answer.last())
            }
        }
        return answer.toString()
    }

}

fun main() {
    var newId = "abcdefghijklmn.p"
//    println(No72410().solution(newId))
    println(No72410().solution2(newId))
}