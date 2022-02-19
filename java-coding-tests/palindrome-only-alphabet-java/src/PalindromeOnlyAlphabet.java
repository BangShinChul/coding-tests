import java.util.Scanner;

public class PalindromeOnlyAlphabet {
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
  public void solution(String sentence) {
    char[] chars = sentence.toLowerCase().toCharArray();
    StringBuilder sentenceOnlyAlphabetBuilder = new StringBuilder();
    for (char item : chars) {
      if(Character.isAlphabetic(item)) {
        sentenceOnlyAlphabetBuilder.append(item);
      }
    }

    String sentenceOnlyAlphabet = sentenceOnlyAlphabetBuilder.toString();
    String reversedOnlyAlphabet = new StringBuilder(sentenceOnlyAlphabet).reverse().toString();
    if (sentenceOnlyAlphabet.equalsIgnoreCase(reversedOnlyAlphabet)) {
      System.out.print("YES");
    } else {
      System.out.print("NO");
    }
  }

  public void solution2(String sentence) {
    String sentenceOnlyAlphabet = sentence.toLowerCase().replaceAll("[^a-z]","");
    String reversedOnlyAlphabet = new StringBuilder(sentenceOnlyAlphabet).reverse().toString();
    if (sentenceOnlyAlphabet.equalsIgnoreCase(reversedOnlyAlphabet)) {
      System.out.print("YES");
    } else {
      System.out.print("NO");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();

    PalindromeOnlyAlphabet poa = new PalindromeOnlyAlphabet();
//    poa.solution(sentence);
    poa.solution2(sentence);
  }

  /**
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
   * - 입력받은 문자열을 lower case로 변환 & char 배열로 변환하고,
   * - foreach 반복문을 통해 loop를 돌면서 Character 구현체에서 제공하는 isAlphabetic 메서드를 활용해 알파벳 여부를 검사했다.
   * - 이 때 알파벳인 경우에만 StringBuilder를 통해 append 했다.
   * - 배열의 모든 element를 검사하고 나서는 StringBuilder의 문자열과 해당 문자열을 reverse 한 문자열을 비교해서 결과를 도출했다.
   *
   * - 문제풀이에서는 replaceAll 메서드를 통해 정규식으로 알파벳이 아닌 모든 문자들을 검출하고 ""으로 치환하여 처리하는 방법을 알려주었다.
   * - 이 코드가 더 심플하고 라인 수도 적지만, 개인적으로는 정규식을 모르는 개발자라면 이 코드가 어떤 의미인지, 이게 정규식인지 아닌지 바로 알기는 어렵지 않을까 싶다.
   * - 하지만 정규식을 조금이라도 알고 있는 개발자에게는 아주 심플하고 깔끔한 코드일 것 같다.
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * - 처음에는 StringBuilder 대신에 List<Character>를 사용했는데 문자열로 변환할 때 `[`와 `]`도 문자열에 포함되어서 올바른 결과를 도출하지 못했다.
   * -
   *
   * */
}
