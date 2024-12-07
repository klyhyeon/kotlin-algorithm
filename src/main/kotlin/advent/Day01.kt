package advent

import java.util.*

class Day01 {

    fun day01() {
        val scanner = Scanner(System.`in`)
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            println(line)
            val twoNumbers = line.split("   ")
            val firstNum = twoNumbers[0].toInt()
            val secondNum = twoNumbers[1].toInt()
            println("first: $firstNum")
            println("second: $secondNum")
            println(firstNum.plus(secondNum))
        }
        scanner.close()
    }
}

fun main() {
    Day01().day01()
}