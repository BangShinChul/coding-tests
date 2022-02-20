import java.util.Scanner;

public class ShortestCharacterDistance {
  /**
   * 가장 짧은 문자 거리.
   *
   * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소 거리를 출력하는 프로그램을 작성하세요.
   *
   * 입력 :
   * 첫 번째 줄에 문자열 s와 문자 t가 주어집니다.
   * 문자열과 문자는 소문자로만 주어집니다.
   * 문자열의 길이는 100을 넘지 않습니다.
   *
   * 출력 :
   * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력합니다.
   *
   * 예시 입력 :
   * teachermode e
   *
   * 예시 출력 :
   * 1 0 1 2 1 0 1 2 2 1 0
   * */
  private void solution(String sentence, char character) {
    char[] chars = sentence.toCharArray();
    int[] result = new int[chars.length];
    int cnt = 1000;

    for (int i = 0; i < chars.length; i++) { // 앞에서부터 순차적으로 카운트
      if (chars[i] == character) {
        cnt=0;
      } else {
        cnt++;
      }
      result[i] = cnt;
    }

    cnt = 1000;
    for (int i = chars.length-1; i >= 0; i--) { // 뒤에서부터 순차적으로 카운트
      if (chars[i] == character) {
        cnt=0;
      } else {
        cnt++;
      }
      result[i] = Math.min(result[i], cnt); // 가장 작은 값으로 결과값 세팅
    }

    for (int item: result) { // 출력
      System.out.print(item+" ");
    }
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    String sentence = input.split(" ")[0];
    char character = input.split(" ")[1].charAt(0);

    ShortestCharacterDistance scd = new ShortestCharacterDistance();
    scd.solution(sentence, character);
  }
  /**
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
   * - 문제의 해법에 대해서 도저히 떠오르지 않아서 문제풀이를 참고하였다.
   * - 문제풀이에서는 두 번의 for loop을 통해서 해결하는 방법을 알려주었다.
   * - 첫번째 loop은 순차적으로, 두번째 loop은 역순으로 진행한다.
   *
   * - 우선 loop을 위해서 문자열을 배열로 만든다.
   * - 그 다음, loop 과정에서 element가 비교대상 문자와 동일한지 검사한다.
   * - 동일하면 cnt 값을 0으로 세팅하여 result 배열의 해당 순서(인덱스)에 집어넣는다.
   * - 동일하지 않으면 cnt + 1 하여 result 배열의 해당 순서(인덱스)에 집어넣는다.
   * - 이 때 중요한 것은 모든 loop 시작 시 cnt 값을 1000과 같은 큰 값으로 지정한 후 시작해야 한다는 것이다.
   * - 이유는 첫번째 loop 이후에 반대로 두번째 loop를 태울 때 첫번째 인덱스에서 올바른 값을 넣어주기 위해서이다.
   * - (loop 시작 시 result의 첫번째 인덱스 or 맨 마지막 인덱스에서 가장 작은 값을 세팅하기 위함)
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * - 처음에 문제를 보았을 때, 한 15분 정도 문제 해결 방법에 대해서 생각했다.
   * - 아무리 생각해봐도 해결 방법이 도저히 떠오르지 않아서 바로 문제풀이를 참고했다.
   * - 바로 문제 해결 방법을 떠올리지 못한 것은 아쉽지만, 괜찮다.
   * - 이렇게 나는 모르던 것을 또 하나 더 배웠다.
   *
   * */
}
