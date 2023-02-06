import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N;

  // 각 칸: 현재 칸에서 갈 수 있는 거리
  // 반드시 오른쪽, 아래쪽으로만 이동 가능
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int[][] board = new int[N + 1][N + 1];
    long[][] dp = new long[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dp[1][1] = 1;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        int next = board[i][j];
        System.out.println("next " + next);
        if (next == 0)
          break;
        if (i + next <= N)
          dp[i + next][j] += dp[i][j];
        if (j + next <= N)
          dp[i][j + next] += dp[i][j];
      }
    }
    System.out.println(Arrays.deepToString(dp));
    System.out.println(dp[N][N]);
  }
}
