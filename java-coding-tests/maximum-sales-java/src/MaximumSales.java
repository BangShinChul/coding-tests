import java.util.Scanner;

public class MaximumSales {

  /**
   * 최대 매출.
   *
   * 현수의 아빠는 제과점을 운영합니다.
   * 현수 아빠는 현수에게 N일 동안의 매출 기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
   * 만약 N=10이고 10일 간의 매출 기록이 아래와 같습니다. 이 때 K=3 이면
   * 12 15 11 20 25 10 20 19 13 15
   * 연속된 3일간의 최대 매출액은 11+20+25 = 56만원 입니다.
   * 여러분이 현수를 도와주세요.
   *
   * 입력 :
   * 첫 번째 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
   * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
   *
   * 출력 :
   * 첫 줄에 최대 매출액을 출력합니다.
   *
   * 예시 입력 :
   * 10 3
   * 12 15 11 20 25 10 20 19 13 15
   *
   * 예시 출력 :
   * 56
   *
   * */

  // sliding window, 오답
  private void solution1(int N, int K, int[] sales) {
    int result = 0;

    for (int i = 0; i < K; i++) {
      result += sales[i];
    }

    for (int i = K; i < N; i++) {
      int sum = result + (sales[i] - sales[i-K]);
      result = Math.max(result, sum);
    }

    System.out.println(result);
  }

  // sliding window, 정답
  private void solution2(int N, int K, int[] sales) {
    int result = 0;
    int sum = 0;

    for (int i = 0; i < K; i++) {
      sum += sales[i];
    }
    result = sum;

    for (int i = K; i < N; i++) {
      sum += (sales[i] - sales[i-K]);
      result = Math.max(result, sum);
    }

    System.out.println(result);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 매출액 데이터 개수
    int K = sc.nextInt(); // 연속된 일 수
    sc.nextLine();
    int[] sales = new int[N];
    for (int i = 0; i < N; i++) {
      sales[i] = sc.nextInt();
    }

    MaximumSales ms = new MaximumSales();
//    ms.solution1(N, K, sales);
    ms.solution2(N, K, sales);
  }
}
/**
 * 문제 풀이 시작 시간 : 2021-12-29 12:10:00
 * 문제 풀이 종료 시간 : yyyy-MM-dd 12:44:00
 *
 * 문제를 어떤 방식으로 접근했는지, 문제의 해법을 찾는 데 결정적이였던 깨달음은 무엇이였는지?
 * - O(n)의 시간복잡도를 가지도록 하려고 노력함.
 * - 이 과정에서, 3개의 값을 더해서 한칸씩 오른쪽으로 이동하며 새로운값을 더하고, 기존 값 중 맨 왼쪽 값을 빼는 식으로 3개 값의 합을 유지하려고 함. (3개의 기준 : K)
 * - solution1을 작성했지만, 오답이여서 결국 문제 풀이를 확인하여 solution2를 작성함.
 * - solution1과 solution2의 결정적인 차이점에 대해서 아직도 이해를 못하고 있음. 좀 더 고민해볼 것.
 *
 * 문제를 한 번에 맞추지 못한 경우 오답 원인이 무엇이였는지?
 * - solution1 의 경우, solution2와 코드가 비슷해 보이지만 결정적으로 무엇이 다르기 때문에 결과가 다른지 이해를 못하였다.
 * - 오답 원인에 대해서 좀 더 파악하고 작성하겠다.
 *
 * */
