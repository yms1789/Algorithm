import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int[] sequence;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    sequence = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[n];
    dp[0] = sequence[0];
    for (int i = 1; i < sequence.length; i++) {
      dp[i] = Math.max(dp[i - 1] + sequence[i], sequence[i]);
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < dp.length; i++) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }

}
