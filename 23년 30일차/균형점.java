import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
  static int N;
  static Map<Integer, Integer> map;
  static int[] xasis;
  static int[] mass;
  static List<Double> res;

  // {x좌표, 질량}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      xasis = new int[N];
      mass = new int[N];
      for (int i = 0; i < N; i++) {
        xasis[i] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < N; i++) {
        mass[i] = Integer.parseInt(st.nextToken());
      }
      res = new ArrayList<>();

      for (int i = 0; i < N - 1; i++) {
        binarySearch(i, xasis[i], xasis[i + 1]);
      }
      System.out.print("#" + tc + " ");
      for (Double xasis : res) {
        System.out.printf("%.10f ", xasis);
      }
      System.out.println();
    }
  }
  // 자성체 2개 -> 1개의 균형점
  // 자성체 3개 -> 2개의 균형점

  static void binarySearch(int div, double left, double right) {

    double x = 0;
    double sum;
    int cnt = 0;
    while (cnt <= 100) {
      x = (left + right) / 2.0;
      sum = 0;
      for (int i = 0; i <= div; i++) {
        sum += gravity(i, x);
      }
      for (int i = N - 1; i > div; i--) {
        sum -= gravity(i, x);
      }
      if (sum > 0) {
        left = x;
      } else {
        right = x;
      }
      cnt++;
    }
    res.add(x);
  }

  static double gravity(int idx, double x) {
    return mass[idx] / ((xasis[idx] - x) * (xasis[idx] - x));
  }
}

/*
 * Solution
 * 처음에는 조합으로 좌표를 나눠서 F가 같은 지점(x)을 방정식을 사용해서 해결하려고 함
 * but, 생각대로 잘 되지 않음...
 * 풀이를 보니 모두 이분 탐색을 통해 적절한 지점을 찾음
 * 이 때, 오차가 10^-12보다는 작아야한다고 함(double형 변수를 가지고 넓은 범위의 이진탐색을 돌릴 때 제한을 걸기 위함)
 * -> 이분탐색을 100~200번 정도만 반복하면 해결할 수 있다고 함(https://www.acmicpc.net/blog/view/37)
 */