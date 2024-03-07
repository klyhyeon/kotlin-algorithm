package programmers.learn.courses.no30.lessons.lv01.no178871

import java.util.*

/* * 달리기 경주
* - 시간초과 실패
* - map BigO 정리하기
* */
class No178871 {

    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val linkedPlayers = LinkedList<String>()
        players.forEach {
            linkedPlayers.add(it)
        }
        callings.forEach {
            val idx = players.indexOf(it)
            val inFrontRunner = players[idx - 1]
            linkedPlayers[idx - 1] = it
            linkedPlayers[idx] = inFrontRunner
        }
        return players
    }

}

fun main() {
    No178871().solution(
        players = arrayOf("mumu", "soe", "poe", "kai", "mine"),
        callings = arrayOf("kai", "kai", "mine", "mine")
    ).forEach { println(it) }
}