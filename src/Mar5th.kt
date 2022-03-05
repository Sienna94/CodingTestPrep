import java.lang.String.join
import java.util.*
import kotlin.collections.ArrayList

class Mar5th {
    //약수의 합
    class Solution1_1{
        fun solution(n: Int): Int {
            var answer = 0
            var arr = ArrayList<Int>()
            for(i in 1..n){
                if(n % i == 0) arr.add(i)
            }
            answer = arr.sum()

            return answer
        }
    }
    class Solution1_2 {
        fun solution(n: Int): Int {
            var answer = 0

            answer = (1..n).filter { n % it == 0 }.sum()

            return answer
        }
    }
    //이상한 문자 만들기
    class Solution2 {
        fun solution(s: String) =
            s.split(" ").joinToString(" ") { word ->
                word
                    .mapIndexed{ index, char ->
                        if ( index % 2 == 0) char.toUpperCase() else char.toLowerCase()
                    }
                    .joinToString("")
            }
    }
    //자릿수 더하기
    class Solution3_1 {
        fun solution(n: Int): Int {
            var answer = 0
            var temp = n.toString()

            for(i in temp.indices){
                answer += (temp.substring(i, i+1)).toInt()
            }

            return answer
        }
    }
    class Solution3_2 {
        fun solution(n: Int): Int {
            var input = n
            var answer = 0

            while (input != 0) {
                answer += input % 10    //10진법, 자릿수를 더해줌
                input /= 10
            }
            return answer
        }
    }
/*    수의 나열 -> 문자열 List 변환
    map으로 숫자의 값을 아스키 코드 값으로 치환 - 48 (0의 아스키 코드)
    sum*/
    class Solution3_3 {
        fun solution(n: Int): Int =
            n.toString().map {
                it.toInt() - '0'.toInt()
            }.sum()
    }
    //자연수 뒤집어 배열로 만들기
    class Solution4_1 {
        fun solution(n: Long): IntArray {
            var answer = intArrayOf()

            n.toString().map{
                answer += (it.toInt() - '0'.toInt())    //숫자 값을 아스키 코드 값으로 치환
            }

            return answer.reversedArray()  // 뒤집기
        }
    }
    class Solution4_2 {
        fun solution(n: Long): IntArray {
            var num = n
            var answer = intArrayOf()

            while(num>0) {
                answer = answer + (num%10).toInt()
                num = num/10
            }

            return answer
        }
    }
}