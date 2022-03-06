import java.lang.Math.max
import java.lang.Math.sqrt
import kotlin.math.pow

class Mar6th {
    //정수 내림차순 배치
    class Solution1_1 {
        fun solution(n: Long): Long {
            var num = n
            var answer: Long = 0
            var tempArr = intArrayOf()
            var tempStr = ""

            while (num > 0) {
                tempArr += (num % 10).toInt()
                num = num / 10
            }

            tempArr.also {
                it.sortDescending()
            }.forEach {
                tempStr += it
            }

            answer = tempStr.toLong()

            return answer
        }
    }

    class Solution1_2 { //문자열 -> CharArray -> 오름차순정렬 -> String -> toLong
        fun solution(n: Long): Long = String(n.toString().toCharArray().sortedArrayDescending()).toLong()
    }

    //정수 제곱근 판별
    class Solution2_1 {
        fun solution(n: Long): Long {
            return if (sqrt(n.toDouble()) % 1 == 0.0) (sqrt(n.toDouble()) + 1).pow(2).toLong() else -1
        }
    }

    class Solution2_2 {
        fun solution(n: Long): Long {
            val sqrt = Math.sqrt(n.toDouble())
            return if (sqrt % 1.0 == 0.0) { // 제곱근이 정수형이면
                Math.pow(sqrt + 1, 2.0).toLong()
            } else {
                -1L
            }
        }
    }

    //제일 작은 수 제거
    class Solution3 { //filter 사용
        fun solution(arr: IntArray): IntArray = if (arr.size == 1) intArrayOf(-1)
        else arr.filter {  it != arr.min() }.toIntArray()
    }

    //짝수와 홀수
    class Solution4 {
        fun solution(num: Int): String {
            var answer = if(num % 2 ==0) "Even" else "Odd"

            return answer
        }
    }
    //최대 공약수 최소공배수
    class Solution5_1 {
        fun solution(n: Int, m: Int): IntArray {
            var greatestCommon = getGreatestCommon(n, m)
            var leastCommon = (n * m) / greatestCommon

            return intArrayOf(greatestCommon, leastCommon)
        }
        fun getGreatestCommon(a: Int, b: Int): Int{
            var maximum = Math.max(a, b)
            var minimum = Math.min(a, b)

            if(minimum == 0){
                return Math.max(a, b)
            }else{
                return getGreatestCommon(minimum, maximum % minimum)
            }
        }
    }
    class Solution5_2 {
        fun solution(n: Int, m: Int): IntArray {
            val gcd = gcd(n, m)

            return intArrayOf(gcd, n * m / gcd)
        }
        // 꼬리 재귀 함수 사용
        tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    }
}