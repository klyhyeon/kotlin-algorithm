package programmers.learn.courses.no30.lessons.lv01.no135808

/* * 과일장수
* - 성공
* */
class No135808First {
  fun solution(k: Int, m: Int, score: IntArray): Int {
    var answer: Int = 0
    if (score.size < m) return 0
    score.sortDescending()
    var lowestNum = Int.MAX_VALUE
    for (i in score.indices) {
      lowestNum = lowestNum.coerceAtMost(score[i])
      if ((i + 1) % m == 0) {
        answer += m * lowestNum
        lowestNum = Int.MAX_VALUE
      }
    }
    return answer
  }
}

fun main() {
  println(No135808First().solution(4, 3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)))
}