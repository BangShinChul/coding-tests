import java.util.Scanner;

public class PalindromeString {

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
  public void solution(String sentence) {
    char[] chars = sentence.toLowerCase().toCharArray();
    for (int i = 0; i < chars.length/2; i++) {
      if(chars[i] != chars[chars.length-i-1]) {
        System.out.print("NO");
        return;
      }
    }
    System.out.print("YES");
  }

  public void solution2(String sentence) {
    String reversedSentence = new StringBuilder(sentence).reverse().toString();
    if (reversedSentence.equalsIgnoreCase(sentence)) {
      System.out.print("YES");
    } else {
      System.out.print("NO");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();

    PalindromeString ps = new PalindromeString();
//    ps.solution(sentence);
    ps.solution2(sentence);
  }
  /**
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
   * - 문자열을 소문자 배열로 변환한 후, 배열의 절반 길이만큼만 반복문을 수행하여 처리했다.
   * - 이 과정에서 맨 앞과 맨 뒤 2개의 문자를 순차적으로 뽑아서 비교 후 틀리면 바로 NO를 출력하고 종료하도록 했고
   * - 반복문에서 나왔을 경우에는 모든 문자가 동일했다는 뜻이므로 YES를 출력하도록 했다.
   *
   * - 문제 풀이에서는 2가지 방법을 알려줬는데, 첫째는 내가 시도했던 방법이였고
   * - 두번째는 입력받은 문자열을 reverse한 문자열과 비교해서 체크하는 것이였다.
   * - 개인적으로는 두번째 방법이 심플했고 이해하기도 훨씬쉬웠다.
   * - 아 나도 이런 쉬운 방법을 바로 떠올렸더라면.. 문제를 접하면 항상 logical한 방식으로 생각을 시작하는 것 같다.
   * - 문제 해결 방법을 좀 더 심플하게 떠올릴 수 있도록 많이 노력해야겠다.
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * -
   *
   * */
}
