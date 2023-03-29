import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
  static class Dir {
    int x;
    int y;

    public Dir(int dx, int dy) {
      this.x = dx;
      this.y = dy;
    }
  }

  static int N, M;
  static int[][] map;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static boolean[][] visited;
  static Queue<Dir> queue;
  static int res;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      map = new int[N][N];
      res = Integer.MIN_VALUE;
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          queue = new LinkedList<>();
          visited = new boolean[N][N];
          bfs(i, j);
        }
      }
      System.out.println("#" + tc + " " + res);
    }

  }

  static void bfs(int i, int j) {
    queue.offer(new Dir(i, j));
    visited[i][j] = true;
    int K = 1;
    int house = map[i][j] == 1 ? 1 : 0;
    if (getOperationCost(K) <= house * M) {
      res = Math.max(K, res);
    }
    while (!queue.isEmpty()) {
      K++;
      int size = queue.size();
      for (int k = 0; k < size; k++) {

        Dir cur = queue.poll();
        for (int n = 0; n < 4; n++) {
          int nx = cur.x + dx[n];
          int ny = cur.y + dy[n];
          if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
            continue;
          if (map[nx][ny] == 1)
            house++;
          queue.add(new Dir(nx, ny));
          visited[nx][ny] = true;
        }
      }
      if (getOperationCost(K) <= house * M) {
        res = Math.max(house, res);
      }
    }
  }

  private static int getOperationCost(int k) {
    return k * k + (k - 1) * (k - 1);
  }
}