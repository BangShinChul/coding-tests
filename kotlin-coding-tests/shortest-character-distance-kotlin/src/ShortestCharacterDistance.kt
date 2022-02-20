import java.util.Scanner
import kotlin.math.min

class ShortestCharacterDistance
/**
 * 가장 짧은 문자 거리.
 *
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소 거리를 출력하는 프로그램을 작성하세요.
 *
 * 입력 :
 * 첫 번째 줄에 문자열 s와 문자 t가 주어집니다.
 * 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않습니다.
 *
 * 출력 :
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력합니다.
 *
 * 예시 입력 :
 * teachermode e
 *
 * 예시 출력 :
 * 1 0 1 2 1 0 1 2 2 1 0
 * */
fun solution(sentence: String, character: Char) {
    val chars = sentence.toCharArray()
    val result = arrayOfNulls<Int>(chars.size)
    var cnt = 1000

    for (i in chars.indices) { // 앞에서부터 순차적으로 카운트
       if (chars[i] == character) {
           cnt=0
       } else {
           cnt++
       }
        result[i] = cnt
    }

    cnt = 1000
    for (i in chars.indices.reversed()) { // 뒤에서부터 순차적으로 카운트
        if (chars[i] == character) {
            cnt=0
        } else {
            cnt++
        }
        result[i] = min(result[i]!!, cnt) // 가장 작은 값으로 결과값 세팅
    }

    result.map { print("$it ") } // 출력
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val input = sc.nextLine()
    val sentence = input.split(" ")[0]
    val character = input.split(" ")[1].single()

    solution(sentence, character)
}
/**
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
 * - 자바로 먼저 문제를 풀어보고 kotlin으로 똑같이 작성해보았다.
 * - (문제 해결을 위한 다른 방법은 생각해내지 못했다.)
 *
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * - kotlin에서 빈 배열을 초기화하는 방법을 까먹어서 조금 헤맸다.
 *
 * */
