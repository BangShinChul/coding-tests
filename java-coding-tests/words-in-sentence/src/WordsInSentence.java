import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordsInSentence {

  /**
   * 문장 속 단어.
   *
   * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
   * 문장속의 각 단어는 공백으로 구분됩니다.
   *
   * 입력 :
   * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다.
   * 문장은 영어 알파벳으로만 구성되어 있습니다.
   *
   * 출력 :
   * 첫 줄에 가장 긴 단어를 출력합니다.
   * 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
   *
   * 예시 입력 1 :
   * it is time to study
   *
   * 예시 출력 1 :
   * study
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();
    String[] words = sentence.split(" ");

    // for-loop 사용
    String result = words[0];
    for (String str: words) {
      if(str.length() > result.length()) {
        result = str;
      }
    }
    System.out.println(result);

    // Stream 사용
    // 성능이 더 안좋음.
    // 또한 reversed 때문에 "가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다" 조건이 만족 안될 수 있음.
//    String result = Arrays.stream(words).sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList()).get(0);
//    System.out.println(result);
  }

  /**
   * 문제 풀이 시작 시간 : 2021-12-24 10:00:00
   * 문제 풀이 종료 시간 : 2021-12-24 10:15:00
   *
   * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지 ?
   * - 문자열을 입력 받을 때, 공백 기준으로 split 처리한 결과를 단순하게 문자열 길이 기준으로 내림차순 정렬하면 좀 더 빠르게 결과를 찾을 수 있지 않을까 생각하게 되었음.
   * - 하지만, "가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다" 라는 기준에 의해 정렬을 하면 요구사항을 충족하지 못할 가능성이 생김.
   * - 따라서 단순하게 for-each를 사용하여 공백 기준으로 split 처리한 결과에서 가장 긴 문자열을 result라는 String 타입 변수에 갱신하도록 처리함.
   * - 문자 갯수에 대해서 O(n)의 시간복잡도를 가짐.
   *
   * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
   * - 처음에 Java Stream 기능을 활용하여 문자 배열을 정렬하여 단순하게 처리하려 하였으나,
   * - "가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다" 라는 기준에 의해 정렬을 하면 요구사항을 충족하지 못할 가능성이 생기는 것을 알아차렸다.
   * - 그래서 다시 for-each를 사용하여 처리하도록 개선하였다.
   *
   * */
}
