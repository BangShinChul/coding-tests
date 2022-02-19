import java.util.Scanner

class RemoveDuplicateCharacter

/**
 * 중복 문자 제거.
 *
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 무자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 * 입력 :
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 출력 :
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 *
 * 예시 입력 :
 * ksekkset
 *
 * 예시 출력 :
 * kset
 */
fun solution1(sentence: String) {
    val charBucket = mutableSetOf<Char>() // 한번이라도 발견된 문자를 저장하는 버킷.
    sentence.toList().map {
        if (!charBucket.contains(it)) {
            print(it)
            charBucket.add(it)
        }
    }
}

fun solution2(sentence: String) {
    sentence.forEachIndexed { index, item ->
        if (sentence.indexOf(item) == index) print(item)
    }
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val sentence = sc.nextLine()

//    solution1(sentence)
    solution2(sentence)
}

/**
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지 ?
 * - 자바로 먼저 문제를 풀어보고 kotlin으로 다시 시도해보았다.
 * - 자바에서는 List만 사용해서 풀었지만 여기서는 좀 다른 방법을 시도했다.
 * - 먼저, 입력받은 문자열을 List로 변환 후 map 메서드로 element들을 하나씩 꺼냈다.
 * - 그리고 꺼낸 값들을 프린트하고 mutable한 Set에 하나씩 적재했다.
 * - 다음 element를 꺼낼 때부터는 Set을 참조해서 이미 출력된 element 였는지 확인 후 출력하도록 했다.
 * - 이렇게 하면 이미 출력된 문자였는지 파악하기 위해서 검증하는 로직이 가벼워진다. (최대 검증 개수 = 알파벳 대소문자 총합 52개)
 *
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * - kotlin에서는 Collection에 대해서 mutable, immutable 구현체가 나누어져 있다는 특징을 깜박하고 HashSet<Char>()을 만들었다.
 * - 이 부분을 다시한번 인지하고 다음엔 똑같은 실수가 없도록 해야겠다.
 *
 * */
