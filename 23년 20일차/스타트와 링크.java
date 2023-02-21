import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static boolean[] visited;
  static int[][] ability;
  static int MIN = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    ability = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        ability[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    visited = new boolean[N];
    combination(0, 0);
    System.out.println(MIN);
  }

  public static void combination(int idx, int depth) {
    if (depth == N / 2) {
      calcDiff();
      return;
    } else {
      for (int i = idx; i < N; i++) {
        if (!visited[i]) {
          visited[i] = true;
          combination(i + 1, depth + 1);
          visited[i] = false;
        }
      }
    }
  }

  public static void calcDiff() {
    int start = 0;
    int link = 0;
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (visited[i] && visited[j]) {
          start += ability[i][j];
          start += ability[j][i];
        } else if (!visited[i] && !visited[j]) {
          link += ability[i][j];
          link += ability[j][i];
        }
      }
    }
    int val = Math.abs(start - link);
    if (val == 0) {
      System.out.println(val);
      System.exit(0);
    }
    MIN = Math.min(val, MIN);
    return;
  }
}
