import java.util.Scanner;

public class ParsingOnlyNumerics {
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
   */
  private void solution(String sentence) {
    char[] chars = sentence.toCharArray();
    boolean startNumericFlag = false; // 숫자 출력 시작 플래그

    for (char item : chars) {
      if (!Character.isDigit(item)) { // 숫자가 아닐경우 조기반환
        continue;
      }

      if (Character.getNumericValue(item) > 0) { // 1 이상의 숫자 출력 케이스
        startNumericFlag = true;
        System.out.print(item);
        continue;
      }

      if (startNumericFlag) { // 0 숫자 출력 케이스
        System.out.print(item);
      }
    }
  }

  private void solution2(String sentence) {
    int answer = 0;
    for (char item: sentence.toCharArray()) {
      if (item >= 48 && item <= 57) answer = answer * 10 + (item - 48); //ASCII 코드로 48~57은 숫자 0~9임
    }
    System.out.println(answer);
  }

  private void solution3(String sentence) {
    StringBuilder answer = new StringBuilder();
    for (char item: sentence.toCharArray()) {
      if (Character.isDigit(item)) answer.append(item);
    }
    System.out.println(Integer.parseInt(answer.toString()));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();

    ParsingOnlyNumerics pon = new ParsingOnlyNumerics();
//    pon.solution(sentence);
//    pon.solution2(sentence);
    pon.solution3(sentence);

  }
  /**
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
   * - 먼저 문자열을 문자 배열로 만든 후, for loop를 돌면서 각 문자가 숫자형(Digit)인지 체크하였다.
   * - 그리고 1 이상의 숫자를 먼저 출력하도록 if 조건을 만들고 숫자 출력이 시작됨을 boolean 변수로 만들어서
   * - 이 후 0이 발견되었을 경우 프린트 할 수 있도록 했다.
   *
   * - 문제풀이에서는 ASCII 코드로 해결하는 방법, 숫자를 판단하여 문자열로 합친 후 Integer로 캐스팅해서 출력하는 방법을 알려주었다.
   * - 개인적으로는 문자열로 숫자들을 합친 후 Integer로 캐스팅해서 출력하는 방법이 가독성도 좋고 코드 수도 적어 좋았다.
   * - ASCII 코드로 해결하는 방법도 간단했지만, 만약 ASCII 코드를 모른다면 코드를 이해하기 어려울 것 같았다.
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * -
   *
   * */
}
