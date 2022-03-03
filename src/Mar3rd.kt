import java.util.PriorityQueue

class Mar3rd {
    //가운데 글자 가져오기
    class Solution1 {
        fun solution(s: String) = s.slice(((s.length - 1) / 2)..(s.length / 2))
    }
    //나누어 떨어지는 숫자 배열
    class Solution2 {
        class Solution {
            fun solution(arr: IntArray, divisor: Int): IntArray {
                var answer = intArrayOf()

                arr.forEach { if (it % divisor == 0) answer += it }
                answer.sort()

                if (answer.isEmpty()) answer += -1

                return answer
            }
        }
    }
    //두 정수 사이의 합
    class Solution3 {
        fun solution(a: Int, b: Int): Long {
            var answer = 0L

            if(a > b) {
                for(n in b.. a) {
                    answer += n
                }
            } else {
                for(n in a.. b) { //어차피 같은 수라면 n은 한번만 더해짐
                    answer += n
                }
            }
            return answer
        }
    }
    //문자열 내 마음대로 정렬하기
    class Solution4_1{ //Comparator 사용
        fun solution(strings: Array<String>, n: Int): Array<String> {
            return strings.sortedWith(Comparator<String> { a, b ->
                if(a[n] == (b[n])) a.compareTo(b)
                else a[n].compareTo(b[n])
            }).toTypedArray()
        }
    }
    class Solution4_2{ //also, sortBy() 사용
        fun solution(strings: Array<String>, n: Int): Array<String> {
            return strings.also {
                it.sort()
                it.sortBy { it[n] }
            }
        }
    }
    //디스크 컨트롤러
    class Solution5_1 {
        fun solution(jobs: Array<IntArray>): Int {
            var answer = 0
            var time = 0
            val waitingQueue = PriorityQueue<Job>(compareBy{it.start}) //작업의 요청시간을 기준으로 정렬

            for(i in jobs.indices){
                val job = Job(jobs[i][0], jobs[i][1])
                waitingQueue.offer(job) //대기큐에 작업을 넣어준다
            }

            while(!waitingQueue.isEmpty()){
                val readyQueue = PriorityQueue<Job>(compareBy {it.during})  //작업 소요시간 기준으로 정렬
                while(!waitingQueue.isEmpty() && time >= waitingQueue.peek().start){ //대기큐가 비어있지 않고, 가장 상단에 위치한 작업의 시작시간이 소요시간보다 작으면
                                                                                        // 즉, 대기하는 작업이 이미 시작됐으면
                    readyQueue.offer(waitingQueue.poll())   //작업 완료 큐에  넣어준다.
                }
                if(readyQueue.isEmpty()){   //대기 큐가 비었을 때, (모든 작업을 완료하면)
                    time++
                    continue
                }
                time += readyQueue.peek().during
                answer += time - readyQueue.peek().start
                readyQueue.poll()

                for(i in 0 until readyQueue.size){
                    waitingQueue.offer(readyQueue.poll())
                }
            }

            answer /= jobs.size //각 작업의 평균값

            return answer
        }
    }
    //데이터 클래스 선언 (작업 요청시간/ 소요시간)
    data class Job(
        var start:Int = 0,
        var during:Int = 0
    )

    class Solution5_2{
        fun solution(jobs: Array<IntArray>): Int {
            var jobList = jobs.map { it[0] to it[1]}.sortedBy { it.first } //요청 시간을 기준으로 정렬하고,
            var sortedTime: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second })
            var current = 0
            var sum = 0
            while (!jobList.isEmpty() || !sortedTime.isEmpty()) {
                val c = jobList.takeWhile { it.first <= current }
                sortedTime.addAll(c)
                jobList = jobList.drop(c.size)
                if (sortedTime.isEmpty()) {
                    current = jobList.first().first
                } else {
                    val j = sortedTime.poll()
                    current += j.second
                    sum += current - j.first
                }
            }

            return sum / jobs.size
        }
    }
}