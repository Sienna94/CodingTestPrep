class Mar8th {
    //핸드폰 번호 가리기
    class Solution1_1 {
        fun solution(phone_number: String): String {
            var answer = ""
            var temp = StringBuilder()
            for (i in phone_number.indices) {
                if (i < phone_number.length - 4) {
                    temp.append("*")
                } else {
                    temp.append(phone_number.substring(i, i + 1))
                }
            }
            answer = temp.toString()

            return answer
        }
    }

    class Solution1_2 {
        fun solution(phone_number: String): String {
            //padStart()로 *을 채우고, takeLast(4)로 끝 4자리를 반환
            return "${"".padStart(phone_number.length - 4, '*')}${phone_number.takeLast(4)}"
        }
    }

    //행렬 덧셈
    class Solution2 {
        fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
            //반환할 array의 사이즈를 정해줘야 함
            return Array<IntArray>(arr1.size) { i -> IntArray(arr1[0].size) { j -> arr1[i][j] + arr2[i][j] } }
        }
    }

    //x만큼 간격이 있는 n개 숫자
    class Solution3 {
        // (long)(x * i) 식으로 처리하면 int형으로 계산되고 그 다음에 long으로 변경된 값이 들어감
        //(long)x * i 으로 해야함
        fun solution(x: Int, n: Int): LongArray = LongArray(n) { x.toLong() * (it + 1) }
    }

    //직사각형 별찍기
    fun main(args: Array<String>) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)

        for (i in 0 until b) {
            for (j in 0 until a) {
                print("*")
            }
            println()
        }
    }
}