class Mar9th {
    //문자열 압축
    class Solution1 {
        fun solution(s: String): Int{
            var level = 1   //비교할 부분 문자열 길이
            var size = s.length //전체 문자열 길이
            var min = s.length //?????

            while(level <= size){
                var str = s.substring(0, level)
                var isChange = false //boolean으로 해당 부분이 반복되는지를 chk
                var sb = StringBuilder() //String에 + 해주는 것보다 StringBuilder가 더 빠름
                var cnt = 2     //반복 카운트는 2부터 반복
                var temp = ""

                var j = level //????????

                while(j + level <= size){   //반복되는 str의 합이 전체 문자열보다 작아야 함
                    val sub = s.substring(j, j+level) // 기준 문자 이후부터 비교한다.
                    if(str == sub){ //다음 문자가 반복이 되면
                        isChange = true //바뀌었다는 flag 표시해주고
                        temp = cnt.toString() + str // 반복수 cnt를 str 앞에 붙여준다
                        cnt ++
                    }else{  //반복되지 않았을 경우 반복이 중단되었을 경우
                        //문자열에 변화가 있을 경우 바뀐 문자열을 builder에 넣어주고, 아니면 문자열 그대로를 넣어줌
                        sb.append(if(isChange) temp else str)
                        isChange = false //바꿀 문자열이 없으니 false로 표시
                        str = sub   //  바뀐 거 없이 그대로
                        temp = "" // 역시 바뀐 거 없으니 그대로
                    }

                    j += level
                }
                if(temp.isEmpty()){ //바뀐 게 없으면
                    sb.append(s.substring(j-level, size))
                }else{
                    sb.append(temp+s.substring(j, size)) //앞에는 바뀐 문자열 + 뒤에는 바뀌지 않은 부분
                }
                min = minOf(min, sb.length) // 바뀐 문자열의 길이를 넣어줌,, 이 문자열은 level 올라갈 수록 계속 수정
                level++ //다음 문자열 길이 비교
            }
            return min
        }
    }
}