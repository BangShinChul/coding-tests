import java.util.Scanner;

public class SwitchUpperCaseAndLowerCase {

  /**
   * 대소문자 변환.
   * <p>
   * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
   * <p>
   * 입력 :
   * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않습니다.
   * 문자열은 영어 알파벳으로만 구성되어 있습니다.
   * <p>
   * 출력 :
   * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
   * <p>
   * 예시 입력 1 :
   * StuDY
   * <p>
   * 예시 출력 1 :
   * sTUdy
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text = sc.next();

    StringBuilder sb = new StringBuilder();

    for (char c : text.toCharArray()) {
      if (Character.isLowerCase(c)) {
        sb.append(Character.toUpperCase(c));
      } else {
        sb.append(Character.toLowerCase(c));
      }
    }
    System.out.println(sb);
  }
  /**
   * 문제 풀이 시작 시간 : 2021-12-24 09:45:00
   * 문제 풀이 종료 시간 : 2021-12-24 09:50:00
   *
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지 ?
   * - 단순하게 문자열을 Char Array로 변환한 다음, LowerCase 혹은 UpperCase를 검증하여 서로 반전만 시켜주면 될 것 같다고 생각함.
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * - 문제를 한번에 맞춤.
   *
   * */
}
