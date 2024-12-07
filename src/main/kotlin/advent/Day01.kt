package advent

import java.util.*

class Day01 {

    fun day01() {
        val scanner = Scanner(System.`in`)
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            println(line)
            val twoNumbers = line.split("   ")
            val firstNum = twoNumbers[0]
            val secondNum = twoNumbers[1]
            println("first: $firstNum")
            println("second: $secondNum")
        }
        scanner.close()
    }
}

fun main() {
    Day01().day01()
}