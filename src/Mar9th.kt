import java.util.*

class Mar9th {
    //문자열 압축
    class Solution1_1 {
        fun solution(s: String): Int {
            var level = 1
            val size = s.length
            var min = s.length

            while (level <= size) {		// 문자열 길이를 늘려가면서 while문 돌리기
                var str = s.substring(0, level)	//str을 잘라냄

                var isChange = false
                val sb = StringBuilder()
                var cnt = 2
                var temp = ""

                var j = level
                while (j + level <= size) {
                    val sub = s.substring(j, j + level)
                    if (str == sub) {
                        isChange = true
                        temp = cnt.toString() + str
                        cnt++
                    } else {
                        sb.append(if(isChange) temp else str)
                        isChange = false
                        str = sub
                        cnt = 2
                        temp = ""

                    }
                    j += level
                }
                sb.append(if(temp.isEmpty()) s.substring(j-level, size) else temp + s.substring(j,size))
                min = minOf(min, sb.length)
                level++
            }
            return min
        }
    }

    class Solution1_2 {
        data class Word(
            val word : String,
            var count : Int = 1
        )
        fun solution(s: String): Int {
            var answer = Int.MAX_VALUE
            for(space in 1..s.length) {
                val compressedWordList = LinkedList<Word>()
                var startIndex = 0
                var endIndex = 0
                while(endIndex != s.length) {
                    endIndex = (startIndex + space).let {
                        if(it > s.length) s.length
                        else it
                    }
                    val currentWord = s.substring(startIndex, endIndex)
                    if(compressedWordList.isEmpty() || compressedWordList.peekLast().word != currentWord) compressedWordList.add(Word(currentWord))
                    else compressedWordList.peekLast().count++
                    startIndex = endIndex
                }
                val length = compressedWordList.fold(0) {
                        acc, word ->
                    acc + word.word.length + if(word.count == 1) 0 else {
                        word.count.toString().length
                    }
                }
                if(length < answer) answer = length
            }
            return answer
        }
    }
}