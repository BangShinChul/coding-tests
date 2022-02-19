import java.util.Scanner

class PalindromeOnlyAlphabet
/**
 * 유효한 회문 문자열(Palindrome String).
 *
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES",
 * 회문 문자열이 아니면 "NO"를 출력하는 프로그램을 작성하세요.
 * 단, 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * 알파벳 이외의 문자들은 무시합니다.
 *
 * 입력 :
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 * 출력 :
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *
 * 예시 입력 :
 * found7,time:study;Yduts;emit,7Dnuof
 *
 * 예시 출력 :
 * YES
 *
 * */
fun solution(sentence: String) {
    val sentenceOnlyAlphabet = sentence.lowercase().filter { it.isLetter() }
    if (sentenceOnlyAlphabet.equals(sentenceOnlyAlphabet.reversed(), ignoreCase = true)) {
        print("YES")
    } else {
        print("NO")
    }
}

fun solution2(sentence: String) {
    val sentenceOnlyAlphabet = sentence.lowercase().replace(Regex("[^a-z]"), "")
    if (sentenceOnlyAlphabet.equals(sentenceOnlyAlphabet.reversed(), ignoreCase = true)) {
        print("YES")
    } else {
        print("NO")
    }
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val sentence = sc.nextLine()

    solution(sentence)
//    solution2(sentence)
}

/**
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
 * - 자바로 먼저 문제를 풀고 Kotlin으로 다시 풀어보았는데 Kotlin의 filter 함수를 사용하여 문자(isLetter)만 필터링 되도록 로직을 작성하였다.
 * - 그리고 필터링된 문자열과 해당 문자열을 reversed한 것을 비교해서 결과를 출력하도록 했다.
 *
 * - solution2에서는 문제풀이에서 알려준 방법을 Kotlin으로 포팅해보았는데
 * - 자바에서는 정규식을 사용함으로써 코드 라인이 줄고 가독성이 좋아졌었지만, 코틀린에서는 오히려 가독성을 더 헤쳤다. (개인적으로는 첫번째 방식이 더 잘 읽힘)
 *
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * -
 *
 * */

