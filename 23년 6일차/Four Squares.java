import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    int[] dp = new int[50001];
    for (int i = 1; i * i <= num; i++) {
      dp[i * i] = 1;
    }
    for (int i = 1; i <= num; i++) {
      if (dp[i] != 0)
        continue;
      for (int j = 1; j * j <= i; j++) {
        if (dp[i] == 0) {
          dp[i] = dp[j * j] + dp[i - j * j];
        } else {
          dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
        }
      }
    }
    System.out.println(dp[num]);
  }
}
