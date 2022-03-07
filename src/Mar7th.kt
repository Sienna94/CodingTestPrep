class Mar7th {
    //콜라츠 추측
    class Solution1 { //꼬리재귀 사용
        fun solution(num: Int): Int = collatzAlgorithm(num.toLong(),0)

        tailrec fun collatzAlgorithm(n:Long, c:Int):Int =
            when{
                c > 500 -> -1
                n == 1L -> c
                else -> collatzAlgorithm(if( n%2 == 0L ) n/2 else (n*3)+1, c+1)
            }
    }
    class Solution1_2 { //toLong() :  홀수 -> 짝수 -> 홀수 -> 짝수 형태를 계속 반복하면 num이 int 형이라서 오버플로우 발생
        fun solution(num: Int): Int {
            var longNum = num.toLong()
            var count = 0
            while (count < 500 && longNum > 1) {
                count ++
                longNum = if (longNum % 2 == 0L) longNum / 2 else longNum * 3 + 1
            }
            return if (count == 500) -1 else count
        }
    }
    //평균 구하기
    class Solution2_1 {
        fun solution(arr: IntArray): Double {
            var answer = (arr.sum().toDouble()) / (arr.size)
            return answer
        }
    }
    class Solution2_2 {
        fun solution(arr: IntArray): Double
        {
            return arr.average() //코틀린스럽게!
        }
    }
    class Solution3_1 {
        fun solution(x: Int): Boolean = isHarshad(x)

        fun isHarshad(n: Int): Boolean {
            var sum = 0
            val str = n.toString()

            for(i in str.indices){
                sum += (str.substring(i, i+1)).toInt()
            }

            print("sum = $sum, n = $n, result = $n % sum")

            return n % sum == 0
        }
    }
    class Solution3_2 {
        fun solution(x: Int): Boolean {
            var sum = 0
            var num = x

            while (num > 0) {
                sum += num % 10
                num /= 10
            }

            return (x % sum == 0)
        }
    }
    class Solution3_3 { //accumulation 함수 fold() 사용 , -48?
        fun solution(x: Int): Boolean {
            return x % x.toString().fold(0){acc, c -> acc + c.toInt() - 48} == 0
        }
    }
}