import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    BigInteger[][] pascal = new BigInteger[101][101];
    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == i || j == 0) {
          pascal[i][j] = BigInteger.ONE;
        } else {
          pascal[i][j] = pascal[i - 1][j].add(pascal[i - 1][j - 1]);
        }
      }
    }
    System.out.println(pascal[N][M]);
  }
}
