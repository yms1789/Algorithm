import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw4_power {
  static int tc;
  static int N;
  static int M;
  static int pow;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int tc = 1; tc <= 10; tc++) {
      pow = 1;
      tc = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      power(0);

      System.out.println("#" + tc + " " + pow);
    }
  }

  static void power(int depth) {
    if (depth == M) {
      return;
    }
    pow *= N;
    power(depth + 1);
  };
}