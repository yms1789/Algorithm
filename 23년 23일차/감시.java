import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Dir {
  int x;
  int y;

  Dir(int dx, int dy) {
    this.x = dx;
    this.y = dy;
  }
}

public class Main {
  static int N;
  static int M;
  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, -1, 0, 1 };
  static int[][] office;
  static int[][] visited;
  static List<Dir> cctv;
  static int minNum = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    office = new int[N][M];
    cctv = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        office[i][j] = Integer.parseInt(st.nextToken());
        if (1 <= office[i][j] && office[i][j] < 6) {
          cctv.add(new Dir(i, j));
        }
      }
    }
    dfs(office, 0);
    System.out.println(minNum);

  }

  public static void dfs(int[][] map, int depth) {
    if (depth == cctv.size()) {
      int count = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (map[i][j] == 0)
            count++;
        }
      }
      minNum = Math.min(count, minNum);
      return;
    }

    Dir curCctv = cctv.get(depth);
    int cx = curCctv.x;
    int cy = curCctv.y;
    int cctvType = office[cx][cy];

    if (cctvType == 1) {
      for (int i = 0; i < 4; i++) {
        int[][] clone = new int[N][M];
        for (int j = 0; j < N; j++) {
          for (int k = 0; k < M; k++) {
            clone[j][k] = map[j][k];
          }
        }
        watch(clone, i, cx, cy);
        dfs(clone, depth + 1);
      }
    }
    if (cctvType == 2) {
      for (int i = 0; i < 2; i++) {
        int[][] clone = new int[N][M];
        for (int j = 0; j < N; j++) {
          for (int k = 0; k < M; k++) {
            clone[j][k] = map[j][k];
          }
        }
        watch(clone, i, cx, cy);
        watch(clone, i + 2, cx, cy);
        dfs(clone, depth + 1);
      }
    }
    if (cctvType == 3) {
      for (int i = 0; i < 4; i++) {
        int[][] clone = new int[N][M];
        for (int j = 0; j < N; j++) {
          for (int k = 0; k < M; k++) {
            clone[j][k] = map[j][k];
          }
        }
        if (i == 3) {
          watch(clone, i, cx, cy);
          watch(clone, i - 3, cx, cy);
        } else {
          watch(clone, i, cx, cy);
          watch(clone, i + 1, cx, cy);
        }
        dfs(clone, depth + 1);
      }
    }
    if (cctvType == 4) {
      for (int i = 0; i < 4; i++) {
        int[][] clone = new int[N][M];
        for (int j = 0; j < N; j++) {
          for (int k = 0; k < M; k++) {
            clone[j][k] = map[j][k];
          }
        }
        for (int l = 0; l < 4; l++)
          if (l != i)
            watch(clone, l, cx, cy);
        dfs(clone, depth + 1);
      }
    }
    if (cctvType == 5) {
      int[][] clone = new int[N][M];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          clone[i][j] = map[i][j];
        }
      }
      for (int i = 0; i < 4; i++) {
        watch(clone, i, cx, cy);
      }
      dfs(clone, depth + 1);
    }
  }

  public static void watch(int[][] clone, int dir, int cx, int cy) {
    while (true) {
      cx += dx[dir];
      cy += dy[dir];
      if (cx >= 0 && cy >= 0 && cx < N && cy < M && clone[cx][cy] != 6) {
        if (clone[cx][cy] == 0)
          clone[cx][cy] = -1;
      } else
        break;
    }
  }
}
