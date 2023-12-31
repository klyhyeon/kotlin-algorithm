package programmers.learn.courses.no30.lessons.lv01.no133502

import java.util.LinkedList

/* * 햄버거 만들기
* - 실패(모르겠다)
* - 뒤에서부터 해야함. 그럼 i에서 3을 빼준 값부터 반복해서 확인해야하는 중복작업이 없어짐
* */
class No133502 {

    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        // 1,2,3 연속된 index를 remove?
        val linkedList: LinkedList<Int> = LinkedList()
        ingredient.map { linkedList.add(it) }
        var i = 0
        while (i < linkedList.size) {
            if (i < linkedList.size - 3) {
                if (linkedList[i] == 1 && linkedList[i + 1] == 2 &&
                    linkedList[i + 2] == 3 && linkedList[i + 3] == 1) {
                    answer += 1
                    for (j in 1 .. 4) {
                        linkedList.removeAt(i)
                    }
                    i = 0.coerceAtLeast(i - 3)
                } else {
                    ++i
                }
            } else {
                break
            }
        }
        return answer
    }
}

fun main() {
    println(No133502().solution(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)))
}