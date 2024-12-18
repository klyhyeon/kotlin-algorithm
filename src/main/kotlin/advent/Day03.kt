package advent

import java.util.*

class Day03 {

    fun day03Part1() {
        val scanner = Scanner(System.`in`)
        var corruptedStr = ""
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            if (line == "") break else corruptedStr = line
        }
        scanner.close()
        var result = ""
        getAllNormal(corruptedStr)
        println(result)
    }

    private fun getAllNormal(corruptedStr: String) {
        val regex = Regex("mul([0-9], [0-9])")
        val matches = regex.findAll(corruptedStr)
        println(matches.iterator().forEachRemaining { it.value })
    }

    fun day03Part2() {

    }
}

fun main() {
    Day03().day03Part1()
}
