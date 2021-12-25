import java.util.ArrayList;
import java.util.Scanner;

public class ReverseWord {

  /**
   * 단어 뒤집기.
   * <p>
   * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
   * <p>
   * 입력 :
   * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
   * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다.
   * 단어는 영어 알파벳으로만 구성되어 있습니다.
   * <p>
   * 출력 :
   * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
   * <p>
   * 예시 입력 :
   * 3
   * good
   * Time
   * Big
   * <p>
   * 예시 출력 :
   * doog
   * emiT
   * giB
   */

  /**
   * StringBuilder를 사용해서 해결.
   *
   * @param wordsCount 문자 개수
   * @param words      문자 배열
   */
  private void solution1(int wordsCount, String[] words) {
    StringBuilder reverseWordsBuilder = new StringBuilder();
    String[] reverseWords = new String[wordsCount];

    for (int i = 0; i < wordsCount; i++) {
      reverseWordsBuilder.append(words[i]);
      reverseWords[i] = reverseWordsBuilder.reverse().toString();
      reverseWordsBuilder.delete(0, reverseWordsBuilder.length());
    }

    for (String word : reverseWords) {
      System.out.println(word);
    }
  }

  /**
   * toCharArray를 사용해서 해결.
   *
   * @param wordsCount 문자 개수
   * @param words      문자 배열
   */
  private void solution2(int wordsCount, String[] words) {
    ArrayList<String> reverseWords = new ArrayList<>();

    for (String word : words) {
      char[] charArray = word.toCharArray();
      int lt = 0;
      int rt = word.length() - 1;

      while (lt < rt) {
        char ltChar = charArray[lt];
        char rtChar = charArray[rt];
        charArray[lt] = rtChar;
        charArray[rt] = ltChar;
        lt++;
        rt--;
      }

      reverseWords.add(String.valueOf(charArray));
    }

    for (String reverseWord : reverseWords) {
      System.out.println(reverseWord);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int wordsCount = sc.nextInt();

    String[] words = new String[wordsCount];
    for (int i = 0; i < wordsCount; i++) {
      words[i] = sc.next();
    }

    ReverseWord main = new ReverseWord();
//    main.solution1(wordsCount, words);
    main.solution2(wordsCount, words);
  }

  /**
   * 문제 풀이 시작 시간 : 2021-12-25 17:30:00
   * 문제 풀이 종료 시간 : 2021-12-25 17:51:00
   *
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
   * - StringBuilder 클래스의 reverse 메서드를 사용하여 쉽게 해결하려고 함.
   * - 이 과정에서, 입력받는 문자 각각 개별적으로 reverse를 처리해야하는것을 깨달음. (문자를 입력한 순서대로 출력해야 하므로)
   * - 입력받은 문자를 Char Array로 변환하고, 이 순서를 반전하여 처리할까도 생각했지만, 바퀴를 다시 만들어 사용하는 느낌이라 패스함. (solution2 으로 도출하여 추가함)
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * - StringBuilder 클래스의 reverse 메서드를 사용했으나, 입력 순서까지 반전되어버림.
   * - StringBuilder를 문자열 반전 빌더용으로 사용하여 문자열을 입력받고, 반전 후 비우는 것을 반복 동작하여 문제를 해결함.
   * */
}
