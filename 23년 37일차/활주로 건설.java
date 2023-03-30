import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int N, X;
  static int[][] map;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      X = Integer.parseInt(st.nextToken()); // 경사로 길이
      map = new int[N][N];
      count = 0;
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      for (int i = 0; i < N; i++) {
        if (findRow(i)) {
          count++;
        }
        if (findCol(i)) {
          count++;
        }
      }
      System.out.println("#" + tc + " " + count);
    }
  }

  static boolean findRow(int row) {
    boolean[] visited = new boolean[N];
    for (int i = 0; i < N - 1; i++) {
      int diff = map[row][i] - map[row][i + 1];
      if (diff < -1 || diff > 1) {
        return false;
      } else if (diff == 1) {
        for (int j = 1; j <= X; j++) {
          if (i + j >= N || visited[i + j])
            return false;
          if (map[row][i] - 1 != map[row][i + j])
            return false;
          visited[i + j] = true;
        }
      } else if (diff == -1) {
        for (int j = 0; j < X; j++) {
          if (i - j < 0 || visited[i - j])
            return false;
          if (map[row][i] != map[row][i - j])
            return false;
          visited[i - j] = true;
        }
      }
    }
    return true;
  }

  static boolean findCol(int col) {
    boolean[] visited = new boolean[N];
    for (int i = 0; i < N - 1; i++) {
      int diff = map[i][col] - map[i + 1][col];
      if (diff < -1 || diff > 1) {
        return false;
      } else if (diff == 1) {
        for (int j = 1; j <= X; j++) {
          if (i + j >= N || visited[i + j])
            return false;
          if (map[i][col] - 1 != map[i + j][col])
            return false;
          visited[i + j] = true;
        }
      } else if (diff == -1) {
        for (int j = 0; j < X; j++) {
          if (i - j < 0 || visited[i - j])
            return false;
          if (map[i][col] != map[i - j][col])
            return false;
          visited[i - j] = true;
        }
      }
    }
    return true;
  }
}