import java.util.Scanner

class ParsingOnlyNumerics
/**
 * 숫자만 추출.
 *
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 * 만약 "tge0a1h205er"에서 숫자만 추출하면 0,1,2,0,5 이고 이것으로 자연수를 만들면 1205가 됩니다.
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 * 입력 :
 * 첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 출력 :
 * 첫 줄에 자연수를 출력합니다.
 *
 * 예시 입력 :
 * g0en2T0s8eSoft
 *
 * 예시 출력 :
 * 208
 * */

fun solution(sentence: String) {
    val result = sentence.filter { it.isDigit() }.toInt()
    println(result)
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val sentence = sc.nextLine()

    solution(sentence)
}
/**
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
 * - 자바로 먼저 문제를 풀고 Kotlin으로 다시 작성해보았는데 훨씬 간결하게 해결 가능했다.
 * - 또한 자바에서와 달리 ASCII 코드를 사용할 필요 없이 기본 제공되는 메서드만으로 가독성도 챙기면서 더 쉽게 해결할 수 있었다.
 *
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * -
 *
 * */
