import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[][] home;
  static int res = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    home = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        home[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    home[0][0] = 2;
    home[0][1] = 2;
    int start = 0; // 가로: 0, 세로: 1, 대각: 2
    // 시작은 가로 -> 대각, 가로 밖에 못감
    dfs(start, 0, 1);
    System.out.println(res);
  }

  static void dfs(int type, int nowX, int nowY) {
    if (nowX < 0 || nowX >= N || nowY < 0 || nowY >= N || home[nowX][nowY] == 1) {
      return;
    }
    if (type == 2) {
      if (home[nowX - 1][nowY] == 1 || home[nowX][nowY - 1] == 1)
        return;
    }
    if (nowX == N - 1 && nowY == N - 1) {
      res++;
      return;
    }
    if (type == 0) {
      dfs(2, nowX + 1, nowY + 1);
      dfs(0, nowX, nowY + 1);
    }
    if (type == 1) {
      dfs(2, nowX + 1, nowY + 1);
      dfs(1, nowX + 1, nowY);
    }
    if (type == 2) {
      dfs(2, nowX + 1, nowY + 1);
      dfs(1, nowX + 1, nowY);
      dfs(0, nowX, nowY + 1);
    }
  }

}
