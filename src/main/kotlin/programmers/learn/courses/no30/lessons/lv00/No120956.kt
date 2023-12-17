package programmers.learn.courses.no30.lessons.lv00

/* 옹알이 (1) */
class No120956 {


  fun solution(babbling: Array<String>): Int {
    var answer = 0

    val words = arrayListOf("aya", "ye", "woo", "ma")

    //모든 단어의 조합
    //contains -> words.length의 총합이 contains의 모든 words의 합과 같으면 true

    for (word in babbling) {
      val wordLength = word.length
      var sumLength = 0
      for (designatedWord in words) {
        if (word.contains(designatedWord)) {
          sumLength += designatedWord.length
        }
      }
      if (wordLength == sumLength) {
        answer++
      }
    }

    return answer
  }

  fun solution2(babbling: Array<String>): Int {
    val regex = "aya|ye|woo|ma".toRegex()
    return babbling.map { it.replace(regex, "") }.count { it.isEmpty() }
  }
}

fun main() {
//  println(Babbling().solution(arrayOf("aya", "yee", "u", "maa", "wyeoo")))
  println(No120956().solution(arrayOf("ayaye", "uuuma", "ye", "yemawoo", "ayaa")))
}