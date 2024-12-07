package advent

import java.util.*
import kotlin.math.abs
import kotlin.math.absoluteValue

class Day01 {

    fun day01() {
        val scanner = Scanner(System.`in`)
        val firstNumbers = mutableListOf<Int>()
        val secondNumbers = mutableListOf<Int>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            if (line == "") break
            val twoNumbers = line.split("   ")
            val firstNum = twoNumbers[0].toInt()
            val secondNum = twoNumbers[1].toInt()
            firstNumbers.add(firstNum)
            secondNumbers.add(secondNum)
        }
        firstNumbers.sort()
        secondNumbers.sort()
        val distances = mutableListOf<Int>()
        for (i in 0 until firstNumbers.size) {
            distances.add(
                abs(firstNumbers[i].minus(secondNumbers[i]))
            )
        }
        scanner.close()
        println("answer: ${distances.sum()}")
    }
}

fun main() {
    Day01().day01()
}