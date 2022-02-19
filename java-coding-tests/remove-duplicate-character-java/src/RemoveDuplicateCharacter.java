import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicateCharacter {

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
  public void solution(String sentence) {
    List<Character> result = new ArrayList<>();

    for (char charItem : sentence.toCharArray()) {
      if (!result.contains(charItem)) result.add(charItem);
    }

    result.forEach(System.out::print);
  }

  public void solution2(String sentence) {
    char[] charArr = sentence.toCharArray();

    System.out.print(charArr[0]);
    for (int i = 1; i < charArr.length; i++) {
      if(sentence.indexOf(charArr[i]) == i) System.out.print(charArr[i]);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();

    RemoveDuplicateCharacter rdc = new RemoveDuplicateCharacter();
//    rdc.solution(sentence);
    rdc.solution2(sentence);
  }

  /**
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지 ?
   * - 처음에 중복된 문자열을 제거해야 한다는 조건으로 Set 자료구조를 생각했다.
   * - 그래서 HashSet 구현체로 코드를 작성 후 결과를 실험해봤는데 아차, Set은 순서를 보장하지 않는다는것을 깜박했다.
   * - 빠르게 Set을 List로 바꾸어 로직을 개선했고 예시 입출력으로 테스트 완료.
   *
   * - 문제를 풀고 나서 문제풀이를 보았는데, 훨씬 더 간단하고 가벼운 방법이 있었다..
   * - 바로 String의 indexOf 메서드를 사용해서 해당 문자의 가장 처음 인덱스 값과 현재 위치와 비교하여 동일할 때에만 출력하면 되는 방법이였다.
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * - 한번에 자료구조의 특성을 모두 생각해내지 못했다. (단편적인 특성들만 기억해냄)
   * - 그래도 빠르게 잘못된 부분을 캐치해서 해결할 수 있었다. 다음부터는 바로 즉시 알맞은 방법을 찾아낼 수 있도록 훈련하자.
   *
   * */
}
