class Mar4th {
    //김서방
    class Solution1 {
        fun solution(seoul: Array<String>): String = "김서방은 ${seoul.indexOf("Kim")}에 있다"
    }
    //문자열 내림차순 배치
    class Solution2 {
        fun solution(s: String): String = String(s.toCharArray().sortedArrayDescending())
    }
    //문자열 다루기 기본
    class Solution3 {
        fun solution(s: String) = (s.length == 4 || s.length == 6) && s.all{ it.isDigit() }
    }
    //수박수박수박
    class Solution4_1 {
        fun solution(n: Int): String {
            var answer = ""
            var temp = StringBuilder()
            for(i in 0 until n){
                if(i % 2 == 0) temp.append("수") else temp.append("박")
            }
            answer = temp.toString()
            return answer
        }
    }
    class Solution4_2 {
        //n 크기 만큼의 charArray 사용
        fun solution(n: Int): String = String(CharArray(n,{i-> if(i%2==0) '수' else '박'}))
    }
    //문자열 정수로 바꾸기
    class Solution5 {
        fun solution(s: String): Int {
            return s.toInt()
        }
    }
    //시저암호
    class Solution6_1 {
        fun solution(s: String, n: Int): String =
            s.map {
                when (it) {
                    in 'A'..'Z' -> it.caesar(n, 'A', 'Z')
                    in 'a'..'z' -> it.caesar(n, 'a', 'z')
                    else -> it
                }
            }.joinToString("")

        fun Char.caesar(c: Int, n: Char, m: Char): Char =
            (n.toInt() + (toInt() - n.toInt() + c) % (m - n + 1)).toChar()
    }
    class Solution6_2 {
        fun solution(s: String, n: Int): String =
            s.toList().joinToString(separator = "") {
                when (it) {
                    in 'A'..'Z' -> ('A'.toInt() + (it.toInt() - 'A'.toInt() + n) % ('Z' - 'A' + 1)).toChar()
                    in 'a'..'z' -> ('a'.toInt() + (it.toInt() - 'a'.toInt() + n) % ('z' - 'a' + 1)).toChar()
                    else -> it
                }.toString()
            }
    }
}