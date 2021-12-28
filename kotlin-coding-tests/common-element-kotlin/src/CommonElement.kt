import java.util.Scanner

class CommonElement

/**
 * 공통원소 구하기.
 *
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 *
 * 입력 :
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000 이하의 자연수 입니다.
 *
 * 출력 :
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 *
 * 예시 입력 :
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 *
 * 예시 출력 :
 * 2 3 5
 *
 * */

fun solution1(A: Array<Int>, B: Array<Int>) {
    val result = mutableListOf<Int>()

    A.sort()
    B.sort()

    for (i in A) {
        for (j in B) {
            if (i == j) {
                result.add(i)
                break
            }
        }
    }

    for (item in result) {
        print("$item ")
    }
}

// two pointers algorithm 사용
fun solution2(N: Int, A: Array<Int>, M: Int, B: Array<Int>) {
    val result = mutableListOf<Int>()

    A.sort()
    B.sort()

    var APointer = 0;
    var BPointer = 0;

    while (APointer < N && BPointer < M) {
        if (A[APointer] == B[BPointer]) {
            result.add(A[APointer])
            APointer++
            BPointer++
        }
        else if (A[APointer] < B[BPointer]) APointer++
        else if (B[BPointer] < A[APointer]) BPointer++
    }

    for (r in result) {
        print("$r ")
    }
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val N = sc.nextInt()
    sc.nextLine()
    val A = sc.nextLine().split(" ").map { it.toInt() }.toTypedArray()

    val M = sc.nextInt()
    sc.nextLine()
    val B = sc.nextLine().split(" ").map { it.toInt() }.toTypedArray()

//    solution1(A, B)
    solution2(N, A, M, B)
}
/**
 * 문제 풀이 시작 시간 : 2021-12-28 23:19:00
 * 문제 풀이 종료 시간 : 2021-12-28 23:29:00
 * 총 10분 소요
 * 하지만 solution2를 모두 푸는데 2021-12-28 24:00:00에 완료 하였으므로,
 * 따지고 보면 총 41분 소요 하였다.
 *
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
 * - 2개의 배열을 오름차순 정렬하여 순서대로 비교해보면 될 것 같았다.
 * - 정렬을 해야하는 것은 옳았지만, solution1 과 같이 비효율적인 방식으로 연산할 경우 테스트에 실패하였다.
 * - 반복 연산을 수행할 때 최대한 가장 적게 연산할 수 있는 방법을 고민해야하는 것을 깨달았다.
 *
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * - solution1을 통해 시도했을때 Time Limit Exceeded에 걸렸다.
 * - 다른 풀이 자료를 보고 solution2를 수행해서 통과하였다.
 * - 오답 원인으로는, solution1에서 이중 for문을 돌아서 비효율적인 연산을 수행해 시간제한에 걸렸던 것으로 생각된다.
 * - 이를 해결하기 위해 solution2에서 two pointer 알고리즘을 채택하여 테스트해보니 통과하였다.
 * - 앞으로는 문제 풀이에 앞서 좀 더 적은 연산을 할 수 있는 방법에 대해 5분정도 고민 후 계획을 세워봐야겠다.
 *
 * */


