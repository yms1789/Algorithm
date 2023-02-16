import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    int[] pay = new int[N + 6];
    int[] date = new int[N + 6];
    int[] dp = new int[N + 6];
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      date[i] = Integer.parseInt(st.nextToken());
      pay[i] = Integer.parseInt(st.nextToken());
    }

    int max = 0;
    for (int i = 1; i <= N + 1; i++) {
      dp[i] = Math.max(dp[i], max);
      dp[date[i] + i] = Math.max(dp[date[i] + i], dp[i] + pay[i]);
      max = Math.max(dp[i], max);
    }
    System.out.println(max);
  }
}