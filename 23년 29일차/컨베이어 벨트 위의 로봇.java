import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, K;
  static int[] belt;
  static boolean[] robots;

  static int state = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 길이
    K = Integer.parseInt(st.nextToken()); // 내구도 개수 K개 이상이면 종료
    belt = new int[2 * N];
    robots = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2 * N; i++) {
      belt[i] = Integer.parseInt(st.nextToken());
    }

    while (true) {

      // step 1.
      move();
      // step 2.
      step2();
      // step 3.
      step3();
      // step 4.
      int zeroCount = step4();
      if (K <= zeroCount) {
        System.out.println(state);
        break;
      }
      state++;
    }

  }

  public static void move() {
    int temp = belt[2 * N - 1];
    for (int i = 2 * N - 1; i >= 1; i--) {
      belt[i] = belt[i - 1];
    }
    belt[0] = temp;

    for (int i = N - 1; i >= 1; i--) {
      robots[i] = robots[i - 1];
    }
    robots[0] = false;
    robots[N - 1] = false;

  }

  public static void step2() {
    for (int i = N - 1; i > 0; i--) {
      if (robots[i - 1] == true && robots[i] == false && belt[i] >= 1) {
        robots[i] = true;
        robots[i - 1] = false;
        belt[i]--;
      }
    }
  }

  public static void step3() {
    if (belt[0] > 0) {
      robots[0] = true;
      belt[0]--;
    }
  }

  public static int step4() {
    int count = 0;
    for (int i = 0; i < 2 * N; i++) {
      if (belt[i] == 0)
        count++;
    }
    return count;
  }
}
