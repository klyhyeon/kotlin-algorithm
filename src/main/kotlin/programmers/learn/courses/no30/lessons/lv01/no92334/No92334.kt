package programmers.learn.courses.no30.lessons.lv01.no92334

/* * 2022 KAKAO BLIND RECRUITMENT 신고 결과 받기
* - 성공
* */
class No92334 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): MutableList<Int> {
        var answer = mutableListOf<Int>()

        val nameReport = linkedMapOf<String, MutableSet<String>>()
        val reportByName = linkedMapOf<String, Int>()
        id_list.forEach {
            nameReport[it] = mutableSetOf()
            reportByName[it] = 0
        }
        report.forEach {
            val splited = it.split(" ")
            val reporter = splited[0]
            val reportee = splited[1]
            nameReport[reporter]!!.add(reportee)
        }
        nameReport.values.forEach { reportees ->
            for (reportee in reportees) {
                reportByName[reportee] = reportByName[reportee]!! + 1
            }
        }
        nameReport.values.forEach { reportees ->
            var answerTmp = 0
            for (reportee in reportees) {
                if (reportByName[reportee]!! >= k) {
                    answerTmp++
                }
            }
            answer.add(answerTmp)
        }

        return answer
    }
}

fun main() {

    val result = No92334().solution(
        id_list = arrayOf("con", "ryan"),
        report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
        k = 3,
    )
    result.forEach { println(it) }
}