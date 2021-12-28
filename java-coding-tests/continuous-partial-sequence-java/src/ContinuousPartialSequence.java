import java.util.Scanner;

public class ContinuousPartialSequence {

  /**
   * 연속 부분수열.
   * <p>
   * N개의 수로 이루어진 수열이 주어집니다.
   * 이 수열에서 연속 부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
   * 만약 N=8, M=6이고 수열이 다음과 같다면
   * 1 2 1 3 1 1 1 2
   * 합이 6이 되는 연속 부분수열은 {2,1,3}, {1,3,1,1}, {3,1,1,1}로 총 3가지 입니다.
   * <p>
   * 입력 :
   * 첫째 줄에 N(1<=N<=100,000), M(1<=M<=100,000,000)이 주어집니다.
   * 수열의 원소값은 1,000을 넘지 않는 자연수입니다.
   * <p>
   * 출력 :
   * 첫째 줄에 경우의 수를 출력합니다.
   * <p>
   * 예시 입력 :
   * 8 6
   * 1 2 1 3 1 1 1 2
   * <p>
   * 예시 출력 :
   * 3
   */

  // O(n^2)
  private void solution1(int N, int M, int[] sequence) {
    int result = 0; // 경우의 수(결과)

    for (int i = 0; i < N-1; i++) {
      int sum = sequence[i];
      for (int j = i+1; j < N; j++) {
        sum += sequence[j];

        if (sum < M) { // 연속부분수열의 합이 M 보다 작은 경우 -> 진행
          continue;
        }
        if (sum > M) { // 연속부분수열의 합이 M 보다 큰 경우 -> 리셋
          sum = 0;
          break;
        }
        if (sum == M) { // 연속부분수열의 합이 M 과 동일한 경우 -> 경우의 수 +1 후 리셋
          result++;
          sum = 0;
          break;
        }
      }
    }

    System.out.println(result);
  }

  // O(n)
  private void solution2(int N, int M, int[] sequence) {
    int result = 0; // 경우의 수(결과)
    int lt = 0;
    int sum = 0;

    for (int rt = 0; rt < N; rt++) {
      sum += sequence[rt];
      if (sum == M) result++; // 연속부분수열의 합이 M과 같으면 경우의 수 ++

      // 연속부분수열의 합이 M 보다 크거나 같은 경우 -> lt++
      while(sum >= M) {
        sum -= sequence[lt];
        lt++;
        if (sum == M) result++; // 연속부분수열의 합이 M과 같으면 경우의 수 ++
      }
    }

    System.out.println(result);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 수열 길이
    int M = sc.nextInt(); // 기준값
    sc.nextLine();
    int[] sequence = new int[N];
    for (int i = 0; i < N; i++) {
      sequence[i] = sc.nextInt();
    }

    ContinuousPartialSequence cps = new ContinuousPartialSequence();
//    cps.solution1(N, M, sequence);
    cps.solution2(N, M, sequence);
  }
}
/**
 * 문제 풀이 시작 시간 : 2021-12-28 21:51:00
 * 문제 풀이 종료 시간 : 2021-12-28 22:01:00
 * 총 10분 소요
 *
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
 * - 처음에는 이중 for문으로 해결하려고 접근했다. 통과는 했지만 성능이 너무 안나왔다.
 * - 시간복잡도가 O(n^2)이다.
 * - 문제 관련 영상을 보고 O(n)의 시간복잡도를 가지는 solution2를 추가로 공부해봄.
 *
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * - 문제는 한번에 맞추었지만, 비효율적인 방식으로 풀이함.
 * - 그래서 효율적인 방식에 대해서 다시한번 공부해봄.
 */
