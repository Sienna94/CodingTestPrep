class March2nd {
    //타겟넘버
    class Solution1 {
        fun solution(numbers: IntArray, target: Int): Int {
            var answer = 0
            fun dfs(sum: Int,idx: Int){
                if(idx<numbers.size-1){
                    //재귀함수 답이 나올 때까지 반복시킨다.
                    dfs(sum+numbers[idx],idx+1)
                    dfs(sum-numbers[idx],idx+1)
                }
                else{
                    //+할 때, -할때 각각 계산한다.
                    if(sum+numbers[idx] == target) {answer++}
                    if(sum-numbers[idx] == target) {answer++}
                }
            }
            dfs(0,0)
            return answer
        }
    }
    //실패율
    class Solution2 {
        fun solution(left: Int, right: Int): Int {
            var answer: Int = 0

            for(i in left until right+1){
                var temp = countDivisor(i)
                if(temp %2 ==0) answer += i else answer -= i
            }

            return answer
        }

        fun countDivisor(num : Int): Int{
            var count = 0

            for(i in 1 until num+1){
                if(num % i == 0) count++
            }

            return count
        }
    }
    //3진법
    class Solution3 {
        fun solution(n: Int): Int {

            return n.toString(3).reversed().toInt(3)
        }
    }
    //두 개 뽑아서 더하기
    class Solution4 {
        fun solution(numbers: IntArray): IntArray {
            val answers: MutableList<Int> = arrayListOf()
            var sum: Int
            var i = 0
            var j = 0

            while (i < numbers.size - 1) {
                j = i + 1
                while (j < numbers.size) {
                    sum = numbers[i] + numbers[j]
                    answers.add(sum)
                    j++
                }

                i++
            }

            answers.sort()
            return answers.distinct().toIntArray()
        }
    }

    //2016년
    class Solution5 {
        fun solution(a: Int, b: Int): String {
            val days = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
            val lastDays = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

            val result = (0 until a - 1).map {
                lastDays[it]
            }.sum() + b


            return days[result % 7]
        }
    }

    //최소직사각형
    class Solution6 {
        fun solution(a: Int, b: Int): String {
            val days = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
            val lastDays = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

            val result = (0 until a - 1).map {
                lastDays[it]
            }.sum() + b


            return days[result % 7]
        }
    }
}