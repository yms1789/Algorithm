package jsAlgorithm.23년 3일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int gcd = N;
    int lcm = M;

    int resA = 0, resB = 0;
    int divide = lcm / gcd;

    for (int i = 1; i <= Math.sqrt(divide); i++) {
      int a, b;
      if (divide % i == 0) {
        a = i;
        b = divide / i;
        if (main.gcd(a, b) == 1) {
          resA = a;
          resB = b;
        }
      }
    }

    System.out.println(resA * gcd + " " + resB * gcd);
  }

  public int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }
}
