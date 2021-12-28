import java.util.Scanner

class ContinuousPartialSequence

/**
 * 연속 부분수열.
 *
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속 부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속 부분수열은 {2,1,3}, {1,3,1,1}, {3,1,1,1}로 총 3가지 입니다.
 *
 * 입력 :
 * 첫째 줄에 N(1<=N<=100,000), M(1<=M<=100,000,000)이 주어집니다.
 * 수열의 원소값은 1,000을 넘지 않는 자연수입니다.
 *
 * 출력 :
 * 첫째 줄에 경우의 수를 출력합니다.
 *
 * 예시 입력 :
 * 8 6
 * 1 2 1 3 1 1 1 2
 *
 * 예시 출력 :
 * 3
 *
 * */

// 시간복잡도 O(n^2)
fun solution1(N: Int, M: Int, sequence: Array<Int>) {

    var result = 0 // 경우의 수(결과)

    for (i in 0 until sequence.size-1) {
        val currentNum = sequence[i]
        var sum = currentNum
        for (j in i+1 until sequence.size) {
            val nextNum = sequence[j]
            sum += nextNum

            if (sum > M) { // 연속부분수열의 합이 M 보다 큰 경우
                // 리셋
                sum = 0
                break
            }
            if(sum < M) { // 연속부분수열의 합이 M 보다 작은 경우
                // 진행
                continue
            }
            if (sum == M) { // 연속부분수열의 합이 M 과 동일한 경우
                // 경우의 수 +1 후 리셋
                result++
                sum = 0
                break
            }
        }
    }

    println(result)
}

// 시간복잡도 O(n)
fun solution2(N: Int, M: Int, sequence: Array<Int>) {
    var result = 0
    var lt = 0
    var sum = 0

    for (rt in 0 until N) {
        sum += sequence[rt]
        if (sum == M) result++

        while (sum >= M) {
            sum -= sequence[lt]
            lt++
            if (sum == M) result++
        }
    }

    println(result)
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val N = sc.nextInt() // 수열 길이
    val M = sc.nextInt() // 기준값
    sc.nextLine()
    val sequence = sc.nextLine().split(" ").map { it.toInt() }.toTypedArray() // 수열

//    solution1(N, M, sequence)
    solution2(N, M, sequence)
}
/**
 * 문제 풀이 시작 시간 : 2021-12-28 21:51:00
 * 문제 풀이 종료 시간 : 2021-12-28 22:01:00
 * 총 10분 소요
 *
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
 * - 처음에는 이중 for문으로 해결하려고 접근했다. 통과는 했지만 성능이 너무 안나왔다.
 * - 시간복잡도가 O(n^2)이다.
 * - 문제 관련 영상을 보고 O(n)의 시간복잡도를 가지는 solution2를 추가로 공부해봄.
 *
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * - 문제는 한번에 맞추었지만, 비효율적인 방식으로 풀이함.
 * - 그래서 효율적인 방식에 대해서 다시한번 공부해봄.
 */
