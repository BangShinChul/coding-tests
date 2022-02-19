import java.util.Scanner

class PalindromeString
/**
 * 회문 문자열(Palindrome String).
 *
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES",
 * 회문 문자열이 아니면 "NO"를 출력하는 프로그램을 작성하세요.
 * 단, 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 * 입력 :
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 * 출력 :
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *
 * 예시 입력 :
 * gooG
 *
 * 예시 출력 :
 * YES
 *
 * */

fun solution(sentence: String) {
    val chars = sentence.lowercase().toCharArray()
    for (i in 0..chars.size/2) {
        if (chars[i] != chars[chars.size-i-1]) {
            print("NO")
            return
        }
    }
    print("YES")
}

fun solution2(sentence: String) {
    if (sentence.equals(sentence.reversed(), ignoreCase = true)) {
        print("YES")
    } else {
        print("NO")
    }
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val sentence = sc.nextLine()

//    solution(sentence)
    solution2(sentence)
}

/**
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
 * - 자바 문제를 먼저 풀어보고 똑같이 Kotlin에서 구현해보았음.
 * - 확실히 Kotlin 코드가 훨씬 가독성이 좋음.
 *
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * -
 *
 * */
