package programmers.learn.courses.no30.lessons.lv01.no77484

/* * 로또의 최고 순위와 최저 순위(2021 Dev-Matching: 웹 백엔드 개발자 상반기)
* - 성공
* */
class No77484First {

    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var matchedNumberCount = 0
        var changeableNumberCount = 0
        lottos.forEach {
            if (win_nums.contains(it)) {
                matchedNumberCount++
            }
            if (it == 0) {
                changeableNumberCount++
            }
        }
        return getRankByMatchedNumber(matchedNumberCount, changeableNumberCount)
    }

    private fun getRankByMatchedNumber(matchedNumberCount: Int, changeableNumberCount: Int): IntArray {
        val highest = matchedNumberCount + changeableNumberCount
        val lowest = matchedNumberCount
        val highestRank = getRank(highest)
        val lowestRank = getRank(lowest)
        return intArrayOf(highestRank, lowestRank)
    }

    private fun getRank(number: Int) = when (number) {
        6 -> 1
        5 -> 2
        4 -> 3
        3 -> 4
        2 -> 5
        else -> 6
    }
}

fun main() {
    println(
        No77484First().solution(
            lottos = intArrayOf(45, 4, 35, 20, 3, 9),
            win_nums = intArrayOf(20, 9, 3, 45, 4, 35),
        ).forEach { print(it) }
    )
}