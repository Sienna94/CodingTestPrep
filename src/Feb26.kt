import java.util.*

class Solution {
    fun solution(name: String): Int {
        var answer = 0
        var alphabetArr = arrayOf<String>("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","S","Y","Z")
        var nameArr = ArrayList<String>()

        for(i in name.indices){
            when(i){
                name.length-1 -> nameArr[i] = name.substring(i)
                else -> nameArr[i] = name.substring(i, i+1)
            }
        }

        nameArr.forEachIndexed{ i, str ->
            if(str != "A" && i != nameArr.size-1){
                alphabetArr.forEachIndexed{ j, alphabet ->
                    if(alphabet == str) answer += j
                }
                answer 
            }else if(str == "A" &&  i != nameArr.size-1){


            }


        }


        return answer
    }
}