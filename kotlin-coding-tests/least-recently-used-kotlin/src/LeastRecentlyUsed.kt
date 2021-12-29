import java.util.Scanner

class LeastRecentlyUsed

/**
 * Least Recently Used.
 *
 * 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
 * 필요할 때 바로 사용해서 처리속도를 높이는 장치입니다.
 * 워낙 비싸고 용량이 작아 효율적으로 사용해야 합니다.
 * 철수의 컴퓨터는 캐시메모리 사용 규칙으로 LRU 알고리즘을 따릅니다.
 * LRU 알고리즘이란 Least Recently Used의 약자로써 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
 * 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘 입니다.
 *
 * 만약 캐시의 사이즈가 5이고 작업이 23167 순으로 저장되어 있다면,
 * (맨 앞이 가장 최근에 쓰인 작업이고, 맨 뒤는 가장 오랫동안 쓰이지 않은 작업입니다.)
 *
 * 1) Cache Miss :
 * 해야할 작업이 캐시에 없는 상태로 위 상태에서 만약 새로운 작업인 5번 작업을 CPU가 사용한다면
 * Cache miss가 되고 모든 작업이 뒤로 밀리고 5번 작업은 캐시의 맨 앞에 위치합니다.
 * 52316 (가장 오랫동안 쓰이지 않은 7번 작업은 캐시에서 삭제됩니다.)
 *
 * 2) Cache Hit : 해야할 작업이 캐시에 있는 상태로 위 상태에서 만약 3번 작업을 CPU가 사용한다면
 * Cache Hit가 되고, 3번 앞에 있는 5,2번 작업은 한 칸 뒤로 밀리고 3번이 맨 앞으로 위치하게 됩니다.
 * 52316 --> 35216
 *
 * 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면
 * N개의 작업을 처리한 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
 *
 * 입력 :
 * 첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력됩니다.
 * 두 번째 줄에 N개의 작업번호가 처리순으로 주어집니다. 작업번호는 1 ~ 100 입니다.
 *
 * 출력 :
 * 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
 *
 * 예시 입력 :
 * 5 9
 * 1 2 3 2 6 2 3 5 7
 *
 * 예시 출력 :
 * 7 5 3 2 6
 *
 * */

fun solution1(cacheSize: Int, workSize: Int, works: Array<Int>) {
    val cache = IntArray(cacheSize) {0} // 캐시의 모든 빈 공간을 0으로 초기화
    var cacheLastIndex = cache.lastIndex

    for (work in works) {
        if (cache.contains(0)) { // 캐시에 아직 공간이 여유 있을 경우 맨 뒤에서부터 넣는다.
            if (cache[cacheLastIndex] == 0) {
                cache[cacheLastIndex] = work
            } else {
                while(cache[cacheLastIndex] != 0) {
                    cacheLastIndex--
                }
                cache[cacheLastIndex] = work
            }
        } else { // 캐시가 꽉차있을 경우
            if (cache.contains(work)) { // 캐시에 작업이 존재하면 Cache Hit
                val workIndex = cache.indexOf(work)
                for (i in workIndex downTo 1) { // 캐시 인덱스부터 시작해서 그 앞의 작업들을 모두 뒤로 한칸씩 밀고
                    cache[i] = cache[i-1]
                }
            } else { // 캐시에 작업이 없으면 Cache Miss
                for (i in cache.lastIndex downTo 1) { // 맨 뒤의 작업을 Cache miss 처리 및 모든 작업을 뒤로 한칸씩 밀고
                    cache[i] = cache[i-1]
                }
            }
            cache[0] = work // 입력받은 작업을 캐시의 맨 앞으로 위치한다.
        }
    }

    for (job in cache) {
        print("$job ")
    }
}

fun solution2(cacheSize: Int, workSize: Int, works: Array<Int>) {
    val cache = IntArray(cacheSize)
    for (work in works) {
        var position = -1;
        for (i in 0 until cacheSize) {
            if (work == cache[i]) position = i
        }
        if (position == -1) { // Cache Miss
            for (i in cacheSize-1 downTo 1) {
                cache[i] = cache[i-1]
            }
        } else { // Cache Hit
            for (i in position downTo 1) {
                cache[i] = cache[i-1]
            }
        }
        cache[0] = work
    }

    for (job in cache) {
        print("$job ")
    }
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val cacheSize = sc.nextInt()
    val workSize = sc.nextInt()
    sc.nextLine()
    val works = sc.nextLine().split(" ").map { it.toInt() }.toTypedArray()

//    solution1(cacheSize, workSize, works)
    solution2(cacheSize, workSize, works)
}
/**
 * 문제 풀이 시작 시간 : 2021-12-29 13:00:ss
 * 문제 풀이 종료 시간 : 2021-12-29 13:43:ss
 * <p>
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
 * - 우선 캐시가 비어있는 경우와 모두 채워진 경우로 나누었고,
 * - 그 다음 캐시가 모두 채워진 경우 에서는 Cache Miss 케이스와 Cache Hit 케이스로 나누어서 생각했다.
 * - solution1을 작성했는데 로컬에서는 정상적으로 결과에 대해서 확인하였지만 채점 도구에서 컴파일 에러를 발생했다.(뭔가 환경이 안맞았던 듯)
 * - 그래서 문제 풀이를 참고하였고, 방식은 내가 접근했던 것과 거의 일치했다. 하지만 문제 풀이의 코드가 훨씬 간결했다.
 *
 * <p>
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * - 문제를 한번에 맞추긴 했지만, 코드를 좀 더 간결하게 작성하는 방법에 대해서 고민해봐야겠다.
 */
