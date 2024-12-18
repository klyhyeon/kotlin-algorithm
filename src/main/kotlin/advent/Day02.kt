package advent

import java.util.*
import kotlin.math.abs

class Day02 {

    fun day02Part1() {
        val scanner = Scanner(System.`in`)
        val reports = mutableListOf<List<Int>>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            if (line == "") break
            val levels = line.split(" ").map { it.toInt() }
            reports.add(levels)
        }
        var result = 0
        for (i in reports.indices) {
            if (!isUnsafe(reports[i].toMutableList()))
                result++
        }
        scanner.close()
        println("answer: $result")
    }

    fun day02Part2() {
        val scanner = Scanner(System.`in`)
        val reports = mutableListOf<MutableList<Int>>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            if (line == "") break
            setUpReport(line, reports)
        }
        var result = 0
        var unsafeCount: Int
        for (i in reports.indices) {
            unsafeCount = 0
            val currentLevelList = reports[i]
            if (isUnsafe(currentLevelList)) {
                unsafeCount++
            }
            if (unsafeCount > 0) {
                for (k in 0 until currentLevelList.size) {
                    val excludedArray = currentLevelList.toMutableList()
                    excludedArray.removeAt(k)
                    if (!isUnsafe(excludedArray)) {
                        result++
                        break
                    }
                }
            } else {
                result++
            }
        }
        scanner.close()
        println("answer: $result")
    }

    private fun setUpReport(line: String, reports: MutableList<MutableList<Int>>) {
        val levels = line.split(" ").map { it.toInt() }.toMutableList()
        reports.add(levels)
    }

    private fun isUnsafe(currentLevelList: MutableList<Int>): Boolean {
        var currentLevel: Int
        var previousLevel = 0
        var isOperationNegative = false
        var levelDistance = 0
        for (j in 0 until currentLevelList.size) {
            currentLevel = currentLevelList[j]
            // first level
            if (j == 0) {
                previousLevel = currentLevelList[j]
                continue
            }
            val distance = previousLevel.minus(currentLevel)
            previousLevel = currentLevelList[j]
            // all increasing/decreasing
            if (j == 1) {
                isOperationNegative = distance < 0
            } else {
                if (distance < 0 != isOperationNegative) {
                    return true
                }
            }
            // adjacent 1~3
            levelDistance = abs(distance)
            if (levelDistance > 3 || levelDistance == 0)
                return true
        }
        return false
    }
}

fun main() {
    Day02().day02Part1()
//    Day02().day02Part2()
}
