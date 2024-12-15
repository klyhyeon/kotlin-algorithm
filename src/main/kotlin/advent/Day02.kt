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
        var currentLevel = 0
        var previousLevel = 0
        var isOperationNegative = false
        var levelDistance = 0
        var result = 0
        var unsafeCount = 0
        for (i in reports.indices) {
            unsafeCount = 0
            for (j in 0 until reports[i].size) {
                currentLevel = reports[i][j]
                // first level
                if (j == 0) {
                    previousLevel = reports[i][j]
                    continue
                }
                val distance = previousLevel.minus(currentLevel)
                previousLevel = reports[i][j]
                // all increasing/decreasing
                if (j == 1) {
                    isOperationNegative = distance < 0
                } else {
                    if (distance < 0 != isOperationNegative) {
                        unsafeCount++
                        break
                    }
                }
                // adjacent 1~3
                levelDistance = abs(distance)
                if (levelDistance > 3 || levelDistance == 0) {
                    unsafeCount++
                    break
                }
            }
            if (unsafeCount == 0) result++
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
            val levels = line.split(" ").map { it.toInt() }.toMutableList()
            reports.add(levels)
        }
        var currentLevel = 0
        var previousLevel = 0
        var isOperationNegative = false
        var levelDistance = 0
        var result = 0
        var unsafeCount = 0
        for (i in reports.indices) {
            unsafeCount = 0
            val currentLevelList = reports[i]
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
                        unsafeCount++
                        break
                    }
                }
                // adjacent 1~3
                levelDistance = abs(distance)
                if (levelDistance > 3 || levelDistance == 0) {
                    unsafeCount++
                    break
                }
            }
            if (unsafeCount > 0) {
                for (k in 0 until currentLevelList.size) {
                    unsafeCount = 0
                    val excludedArray = currentLevelList.toMutableList()
                    excludedArray.removeAt(k)
                    for (l in 0 until excludedArray.size) {
                        currentLevel = excludedArray[l]
                        // first level
                        if (l == 0) {
                            previousLevel = excludedArray[l]
                            continue
                        }
                        val distance = previousLevel.minus(currentLevel)
                        previousLevel = excludedArray[l]
                        // all increasing/decreasing
                        if (l == 1) {
                            isOperationNegative = distance < 0
                        } else {
                            if (distance < 0 != isOperationNegative) {
                                unsafeCount++
                                break
                            }
                        }
                        // adjacent 1~3
                        levelDistance = abs(distance)
                        if (levelDistance > 3 || levelDistance == 0) {
                            unsafeCount++
                            break
                        }
                    }
                    if (unsafeCount == 0) {
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
}

fun main() {
//    Day02().day02Part1()
    Day02().day02Part2()
}
