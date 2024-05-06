package programmers.learn.courses.no30.lessons.lv01.no258712

/*
가장 많이 받은 선물 (2024 카카오 겨울 인턴십)
- 성공 (55 min)
 */
class No258712 {

    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var answer: Int = 0
        val presentRecord = HashMap<Pair<String, String>, Int>()
        val answerMap = LinkedHashMap<String, Int>()
        val presentIndex = LinkedHashMap<String, Int>()
        friends.forEach {
            answerMap[it] = 0
        }
        gifts.forEach {
            val arr = it.split(" ")
            val giver = arr[0]
            val receiver = arr[1]
            if (presentRecord[Pair(giver, receiver)] == null) {
                presentRecord[Pair(giver, receiver)] = 1
            } else {
                var value = presentRecord[Pair(giver, receiver)]!!
                presentRecord[Pair(giver, receiver)] = ++value
            }
        }
        for (me in friends) {
            for (friend in friends) {
                if (friend == me) continue
                if (friends.indexOf(friend) < friends.indexOf(me)) continue
                val myGivenCnt = presentRecord[Pair(me, friend)] ?: 0
                val friendGivenCnt = presentRecord[Pair(friend, me)] ?: 0
                if (myGivenCnt == friendGivenCnt) {
                    if (presentIndex[me] == null) {
                        var myGivenSum = 0
                        var myReceivedSum = 0
                        presentRecord.forEach {
                            if (it.key.first == me) {
                                myGivenSum += it.value
                            } else if (it.key.second == me) {
                                myReceivedSum += it.value
                            }
                        }
                        presentIndex[me] = myGivenSum - myReceivedSum
                    }
                    if (presentIndex[friend] == null) {
                        var friendGivenSum = 0
                        var friendReceivedSum = 0
                        presentRecord.forEach {
                            if (it.key.first == friend) {
                                friendGivenSum += it.value
                            } else if (it.key.second == friend) {
                                friendReceivedSum += it.value
                            }
                        }
                        presentIndex[friend] = friendGivenSum - friendReceivedSum
                    }
                    if (presentIndex[me]!! > presentIndex[friend]!!) {
                        answerMap[me] = answerMap[me]!! + 1
                    } else if(presentIndex[me]!! < presentIndex[friend]!!) {
                        answerMap[friend] = answerMap[friend]!! + 1
                    }
                } else if (myGivenCnt > friendGivenCnt) {
                    answerMap[me] = answerMap[me]!! + 1
                } else {
                    answerMap[friend] = answerMap[friend]!! + 1
                }
            }
        }
        return answerMap.maxOf { it.value }
    }
}

fun main() {
    println(
        No258712().solution(
            friends = arrayOf("a", "b", "c"),
            gifts = arrayOf(
                "a b", "b a", "c a", "a c", "a c", "c a",
            ),
        )
    )
}