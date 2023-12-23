package programmers.learn.courses.no30.lessons.lv01.no64061

import java.util.Stack

/* * 크레인 인형뽑기 게임(2019 카카오 개발자 겨울 인턴십)
* - 실패
* - 문제를 잘 보자. board가 행의 아래에서부터 쌓이는 건줄
* */
class No64061Second {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val bucket = Stack<Int>()
        moves.forEach {
            for (i in board.indices) {
                if (board[i][it - 1] != 0) {
                    if (bucket.isNotEmpty() && board[i][it - 1] == bucket.peek()) {
                        answer += 2
                        bucket.pop()
                    } else {
                        bucket.push(board[i][it - 1])
                    }
                    board[i][it - 1] = 0
                    break
                }
            }
        }
        return answer
    }
}

fun main() {
    println(No64061Second().solution(
        board = arrayOf(
            intArrayOf(0,0,0,0,0),
            intArrayOf(0,0,1,0,3),
            intArrayOf(0,2,5,0,1),
            intArrayOf(4,2,4,4,2),
            intArrayOf(3,5,1,3,1),
        ),
        moves = intArrayOf(1,5,3,5,1,2,1,4),
    ))
}