import java.util.*

//Happy Number
class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var sum = 0
        var tempNum = n
        var hits = HashSet<Int>()

        while(sum != 1){
            sum= 0

            while(tempNum != 0){
                var temp = tempNum % 10
                sum += temp * temp
                tempNum = tempNum / 10
            }

            if(hits.contains(sum)){
                return - 1
            }

            hits.add(sum)
            tempNum = sum
            answer ++
        }

        return answer
    }
}