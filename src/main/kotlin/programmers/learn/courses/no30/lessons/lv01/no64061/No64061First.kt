package programmers.learn.courses.no30.lessons.lv01.no64061

import java.util.Stack

/* * 크레인 인형뽑기 게임(2019 카카오 개발자 겨울 인턴십)
* - 실패
* */
class No64061First {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val newBoard =  Array(board.size) { Stack<Int>() }
        val bucket = Stack<Int>()
        var idx = 0
        board.forEach {
            val indexStack = Stack<Int>()
            for (i in it.indices) {
                indexStack.push(it[i])
            }
            newBoard[idx++] = indexStack
        }

        moves.forEach {
            if (!newBoard[it - 1].empty()) {
                val doll = newBoard[it - 1].pop()
                answer += getPoppedDollsCount(bucket, doll)
            }
        }
        return answer
    }

    fun newSolution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val bucket = Stack<Int>()
        val flagBoard = Array(board.size) { Array(board.size) { false } }

        moves.forEach {
            val moveIdx = it - 1
            for (i in flagBoard[moveIdx].size - 1 downTo 0) {
                if (flagBoard[moveIdx][i]) {
                    continue
                }
                val doll = board[moveIdx][i]
                flagBoard[moveIdx][i] = true
                answer += getPoppedDollsCount(bucket, doll)
            }
        }
        return answer
    }

    fun getPoppedDollsCount(bucket: Stack<Int>, doll: Int): Int {
        if (doll == 0) return 0
        if (!bucket.empty() && bucket.peek() == doll) {
            bucket.pop()
            return 2
        }
        bucket.push(doll)
        return 0
    }
}

fun main() {
    println(No64061First().newSolution(
        board = arrayOf(
            intArrayOf(0,0,0,0,0),
            intArrayOf(0,0,1,0,3),
            intArrayOf(0,2,5,0,1),
            intArrayOf(4,2,4,4,2),
            intArrayOf(3,5,1,3,1),
        ),
        moves = intArrayOf(1,5,3,5,1,2,1,4),
    ))
//    val twoDArray = arrayOf(
//        intArrayOf(2, 4, 6),
//        intArrayOf(1, 3, 5)
//    )
//    twoDArray.forEach {
//        println("zero: ${twoDArray[0][0]}")
//        println("one: ${twoDArray[0][1]}")
//        println("two: ${twoDArray[0][2]}")
//    }
}