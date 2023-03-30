import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
  static int N;
  static int[][] cell;

  static class Dir {
    int x;
    int y;

    public Dir(int dx, int dy) {
      this.x = dx;
      this.y = dy;
    }
  }

  static int lineLength;
  static List<Dir> core;
  static boolean[] visited;
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, 1, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      N = Integer.parseInt(br.readLine());
      cell = new int[N][N];
      core = new ArrayList<>();
      lineLength = Integer.MAX_VALUE;
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          cell[i][j] = Integer.parseInt(st.nextToken());
          if (cell[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
            core.add(new Dir(i, j));
          }
        }
      }
      visited = new boolean[core.size()];
      for (int i = core.size(); i >= 0; i--) {
        combination(0, 0, i);
        if (lineLength < Integer.MAX_VALUE) {
          break;
        }
      }
      System.out.println("#" + tc + " " + lineLength);
    }

  }

  static void combination(int idx, int count, int cores) {
    if (count == cores) {
      dfs(0, 0);
      return;
    }
    for (int i = idx; i < core.size(); i++) {
      visited[i] = true;
      combination(i + 1, count + 1, cores);
      visited[i] = false;
    }
  }

  static void dfs(int idx, int count) {
    if (idx == core.size()) {
      lineLength = Math.min(count, lineLength);
      return;
    }
    if (!visited[idx]) {
      dfs(idx + 1, count);
      return;
    }
    for (int i = 0; i < 4; i++) {
      int curx = core.get(idx).x;
      int cury = core.get(idx).y;
      boolean isConnect = false;
      int len = 0;
      while (true) {
        curx += dx[i];
        cury += dy[i];
        if (curx < 0 || cury < 0 || curx >= N || cury >= N) {
          isConnect = true;
          break;
        }
        if (cell[curx][cury] != 0)
          break;
        cell[curx][cury] = 2;
        len++;

      }
      if (isConnect) {
        dfs(idx + 1, count + len);
      }
      while (true) {
        curx -= dx[i];
        cury -= dy[i];
        if (curx == core.get(idx).x && cury == core.get(idx).y)
          break;
        cell[curx][cury] = 0;
      }
    }
  }
}