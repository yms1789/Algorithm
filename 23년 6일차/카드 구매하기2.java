import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[] cardCost = new int[N + 1];
    int[] dp = new int[N + 1];
    dp[0] = 1001;
    cardCost[0] = 1001;
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      cardCost[i] = Integer.parseInt(st.nextToken());
    }
    dp[1] = cardCost[1];
    for (int i = 2; i <= N; i++) {
      dp[i] = cardCost[i];
      for (int j = 1; j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j] + cardCost[j]);
      }
    }
    System.out.println(dp[N]);
  }
}
