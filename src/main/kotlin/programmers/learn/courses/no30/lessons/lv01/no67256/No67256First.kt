package programmers.learn.courses.no30.lessons.lv01.no67256

/* * 키패드 누르기(2020 카카오 인턴십)
* - 실패(건드리지도 못함)
* */
class No67256First {

    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val column1 = intArrayOf(1, 4, 7)
        val column2 = intArrayOf(2, 5, 8, 0)
        val column3 = intArrayOf(3, 6, 9)
        val answerArray = mutableListOf<String>()
        numbers.forEach {
            if (answerArray.isEmpty() && it == 0) {
                answerArray.add(hand)
            }

        }
        return answer
    }
}

fun main() {

}