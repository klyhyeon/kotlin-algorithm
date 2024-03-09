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

    fun solution2(players: Array<String>, callings: Array<String>): List<String>? {
        val mappedPlayers = HashMap<String, Pair<Int, String?>>()
        var idx = 0
        players.forEach {
            if (idx != 0) {
                mappedPlayers.put(it, Pair(idx, players[idx - 1]))
            } else {
                mappedPlayers.put(it, Pair(0, null))
            }
            idx++
        }
        callings.forEach {
            val pairIdxFormer = mappedPlayers.get(it)
            val former = mappedPlayers.get(pairIdxFormer!!.second)
            mappedPlayers.put(pairIdxFormer.second!!, Pair(former!!.first + 1, it))
            mappedPlayers.put(it, Pair(pairIdxFormer.first - 1, former.second))
        }
        val list = mappedPlayers.toList().sortedBy { it.first }.map { it.first }
        println(list)
        return null
    }

}

fun main() {
    No178871().solution2(
        players = arrayOf("mumu", "soe", "poe", "kai", "mine"),
        callings = arrayOf("kai", "kai", "mine", "mine")
    )?.forEach { println(it) }
}