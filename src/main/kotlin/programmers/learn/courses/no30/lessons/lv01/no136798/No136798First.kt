package programmers.learn.courses.no30.lessons.lv01.no136798

import kotlin.math.pow
import kotlin.math.sqrt

/* * 기사단원의 무기
* - 실패: number의 sqrt를 Double형으로 제곱해주면 number(double)과 항상 일치한다. Int로 변경해서 제곱했을 때 비교해줘야 정수인 제곱근과 그렇지 않은 제곱근을 구별할 수 있다.
* - 성공
* */
class No136798First {

    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer = 0
        for (i in 1..number) {
            val yaksu = getYaksuSucceed(i)
            if (yaksu > limit) answer += power else answer += yaksu
        }
        return answer
    }

    private fun getYaksuFailed(number: Int):Int {
        var yaksuCount = 0
        var sqrt = sqrt(number.toDouble()).toInt()
        for (i in 1 .. sqrt) {
            if (number % i == 0) {
                yaksuCount++
            }
        }
        yaksuCount *= 2
        if (number.toDouble() == sqrt(number.toDouble()).pow(2.0)) yaksuCount--
        return yaksuCount
    }

    private fun getYaksuSucceed(number: Int):Int {
        var yaksuCount = 0
        var sqrt = sqrt(number.toDouble()).toInt()
        for (i in 1 .. sqrt) {
            if (number % i == 0) {
                yaksuCount++
            }
        }
        yaksuCount *= 2
        if (sqrt * sqrt == number) yaksuCount--
        return yaksuCount
    }
}

fun main() {
    println(No136798First().solution(5, 3, 2))
}