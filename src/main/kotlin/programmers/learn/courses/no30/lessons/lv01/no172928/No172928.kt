package programmers.learn.courses.no30.lessons.lv01.no172928

/* * 공원 산책
* - 실패
* */
class No172829 {
    /*
    현재 좌표를 구하고 이를 움직였을 때 좌표를 저장하는 변수 필요
    - var currentPoint
    - val nextPoint
    조건
    - 공원을 벗어나지 않는다.
    - 장애물을 만나지 않는다. (길목에도 장애물이 없어야 한다.) ->
     */
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val answer = IntArray(2)
        for (i in park.indices) {
            if (park[i].contains("S")) {
                answer[0] = i
                answer[1] = park[i].indexOf('S')
            }
        }
        val nextPoint = IntArray(2)
        routes.forEach { route ->
            nextPoint[0] = answer[0]
            nextPoint[1] = answer[1]

            val opAndN = route.split(" ")
            val op = opAndN[0]
            val n = opAndN[1].toInt()
            var flag = false

            when (op) {
                "E" -> {
                    nextPoint[1] = answer[1] + n
                    if (nextPoint[1] < park[0].length) {
                        for (j in answer[1] until answer[1] + n) {
                            if (park[nextPoint[0]].get(j) == 'X') {
                                flag = true
                            }
                        }
                    }
                }

                "W" -> {
                    nextPoint[1] = answer[1] - n
                    if (nextPoint[1] >= 0) {
                        for (j in answer[1] - n until answer[1]) {
                            if (park[nextPoint[0]].get(j) == 'X') {
                                flag = true
                            }
                        }
                    }
                }

                "S" -> {
                    nextPoint[0] = answer[0] + n
                    if (nextPoint[0] < park.size) {
                        for (j in answer[0] until answer[0] + n) {
                            val letter = park[j][nextPoint[1]]
                            if (letter == 'X') {
                                flag = true
                            }
                        }
                    }
                }

                "N" -> {
                    nextPoint[0] = answer[0] - n
                    if (nextPoint[0] >= 0) {
                        for (j in answer[0] - n until answer[0]) {
                            val letter = park[j].get(nextPoint[1])
                            if (letter == 'X') {
                                flag = true
                            }
                        }
                    }
                }
            }

            if (nextPoint[0] >= 0 && nextPoint[0] < park.size
                && nextPoint[1] >= 0 && nextPoint[1] < park[0].length
                && !flag
            ) {

                answer[0] = nextPoint[0]
                answer[1] = nextPoint[1]

            }
        }

        return answer
    }

    fun solution2(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf(0, 0)
        val order = HashMap<String, IntArray>()
        order.put("E", intArrayOf(0, 1))
        order.put("W", intArrayOf(0, -1))
        order.put("S", intArrayOf(1, 0))
        order.put("N", intArrayOf(-1, 0))

        for (i in park.indices) {
            if (park[i].contains("S")) {
                answer[0] = i
                answer[1] = park[i].indexOf('S')
            }
        }

        routes.forEach { route ->
            val opAndN = route.split(" ")
            val op = opAndN[0]
            val n = opAndN[1].toInt()

            val move = order[op]!!
            var height = answer[0]
            var width = answer[1]
            var flag = false
            for (j in 1 .. n) {
                height += move[0]
                width += move[1]
                if (!(height >= 0 && height < park.size && width >= 0 && width < park[0].length && park[height][width] != 'X')) {
                    flag = true
                }
            }
            if (!flag) {
                answer[0] = height
                answer[1] = width
            }
        }
        return answer
    }

}

fun main() {
    No172829().solution2(
        park = arrayOf("OSO", "OOO", "OXO", "OOO"),
        routes = arrayOf("E 2", "S 3", "W 1"),
    ).forEach { println(it) }
}