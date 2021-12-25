import java.util.Locale;
import java.util.Scanner;

public class FindCharacter {

  /**
   * 문자 찾기.
   * <p>
   * 설명 :
   * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
   * <p>
   * 입력 :
   * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어집니다.
   * 문자열은 영어 알파벳으로만 구성되어 있습니다.
   * <p>
   * 출력 :
   * 첫 줄에 해당 문자의 개수를 출력합니다.
   * <p>
   * 예시 입력 1 :
   * Computercooler
   * c
   * <p>
   * 예시 출력 1 :
   * 2
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String text = in.next().toLowerCase(Locale.ROOT);
    char character = in.next().charAt(0);
    character = Character.toLowerCase(character);
    int count = 0;
    for (char c : text.toCharArray()) {
      if (character == c) {
        count++;
      }
    }

    System.out.println(count);
  }
  /**
   * 문제 풀이 시작 시간 : 2021-12-24 09:30:00
   * 문제 풀이 종료 시간 : 2021-12-24 09:40:00
   *
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지 ?
   * - 조건에 대소문자를 구분한다는 제약사항이 없었기 때문에 단순하게 문자열을 입력받으면 소문자 혹은 대문자로 변환하고
   * - 문자열을 Char Array로 변환 후 하나씩 검사하며 카운팅하면 될 것 같다고 생각함.
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * - 문제를 한번에 맞춤.
   *
   * */
}
