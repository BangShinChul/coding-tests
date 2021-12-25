import java.util.Scanner;

public class ReverseSpecialWord {

  /**
   * 특정 문자 뒤집기.
   * <p>
   * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
   * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
   * <p>
   * 입력 :
   * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
   * <p>
   * 출력 :
   * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
   * <p>
   * 예시 입력 :
   * a#b!GE*T@S
   * <p>
   * 예시 출력 :
   * S#T!EG*b@a
   */

  private void solution(String word) {
    char[] charArray = word.toCharArray();
    for (char character : charArray) {
      if (Character.isAlphabetic(character)) {
        System.out.println(character + " is alphabet");
      } else {
        System.out.println(character + " is not alphabet");
      }
    }
  }

  private void solution1(String word) {
    char[] charArray = word.toCharArray();

    int lt = 0;
    int rt = word.length() - 1;

    while (lt < rt) {
      char ltChar = charArray[lt];
      if (Character.isAlphabetic(ltChar)) { // 앞에 char이 알파벳이면?
        while (!Character.isAlphabetic(charArray[rt]) && (lt < rt)) { // 뒤에 char이 알파벳이 나올때까지 lt보다 큰 범위에서 rt-- 수행.
          rt--;
        }
        char rtChar = charArray[rt];
        charArray[lt] = rtChar; // 뒤에 char이 알파벳이면 앞의 알파벳과 교환.
        charArray[rt] = ltChar;
        rt--;
      }
      lt++; // 다음 char로 진행.
    }

    System.out.println(String.valueOf(charArray));
  }

  private void solution2(String word) {
    char[] charArray = word.toCharArray();

    int lt = 0;
    int rt = word.length() - 1;

    while (lt < rt) {
      if(!Character.isAlphabetic(charArray[lt])) lt++; // 앞의 문자가 알파벳이 아닐경우 앞으로 한칸 이동한다.
      else if(!Character.isAlphabetic(charArray[rt])) rt--; // 뒤의 문자가 알파벳이 아닐경우 뒤로 한칸 이동한다.
      else { // 앞의 문자와 뒤의 문자가 모두 알파벳일 경우, 서로 교환하고 이동한다.
        char tmp = charArray[lt];
        charArray[lt] = charArray[rt];
        charArray[rt] = tmp;
        lt++;
        rt--;
      }
    }

    System.out.println(String.valueOf(charArray));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();

    ReverseSpecialWord reverseSpecialWord = new ReverseSpecialWord();
//    reverseSpecialWord.solution1(word);
    reverseSpecialWord.solution2(word);
  }

  /**
   * 문제 풀이 시작 시간 : 2021-12-25 18:46:00
   * 문제 풀이 종료 시간 : 2021-12-25 19:20:00
   * 총 34분 소요 (30분 이상 소요됨)
   *
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
   * - 문자를 Char Array로 변환하여, 앞에서부터 검사하고 알파벳 검색 시 뒤에서부터 검사하여 알파벳을 검색하면 서로 교환하는 방식으로 해결.
   * - 결정적으로 깨달은것은 서로 교환하고 나서 앞과 뒤에서부터 검사한 인덱스 자리를 이동해주어야 함을 깨달음.
   * - 만약 그렇게 해주지 않을 경우 계속 알파벳이기 때문에 동일한 자리에서 계속 교환함.(무한루프)
   * - 그리고 한쪽만이 아닌 앞과 뒤 모두에서 자리 이동을 해주어야 함.
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * - 문제는 한번에 맞추었지만 시간이 생각보다 좀 많이 걸렸다.
   *
   * */
}
