package programmers.learn.courses.no30.lessons.lv01.no150370

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/* * 개인정보 수집 유효기간(2023 KAKAO BLIND RECRUITMENT)
* - 성공
* */
class No150370 {

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): List<Int> {
        val answer: ArrayList<Int> = arrayListOf()
        val todayParsed = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"))
        val termMap = HashMap<String, Int>()
        terms.forEach {
            val termEle = it.split(" ")
            termMap.put(termEle[0], termEle[1].toInt())
        }
        val expireDates: ArrayList<LocalDate> = arrayListOf()
        privacies.forEach {
            val privacyEle = it.split(" ")
            val date = LocalDate.parse(privacyEle[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"))
            val expireMonths = termMap.get(privacyEle[1])
            expireDates.add(date.plusMonths(expireMonths!!.toLong()))
        }
        for (i in expireDates.indices) {
            if (todayParsed >= expireDates[i]) answer.add(i + 1)
        }
        return answer
    }
    // 개인정보 n 개
    // 약관 유효기간
    // 오늘 날짜
    // if 2021-01-05, 12달, 파기: plus(12)
}

fun main() {
    println(
        No150370().solution(
            terms = arrayOf("A 6", "B 12", "C 3"),
            today = "2022.05.19",
            privacies = arrayOf(
                "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"
            ),
        )
    )
}