import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static class Dir {
    int x;
    int y;
    int time;

    public Dir(int dx, int dy, int time) {
      this.x = dx;
      this.y = dy;
      this.time = time;
    }
  }

  static String[][] space;
  static int[][] visited;
  static int R, C;
  static Queue<Dir> queue;
  static Queue<Dir> fireQueue;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static int escape = 0;
  static boolean isEscape = false;
  static int spreadTime = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken()); // 행
    C = Integer.parseInt(st.nextToken()); // 열
    space = new String[R + 1][C + 1];
    visited = new int[R + 1][C + 1];
    queue = new LinkedList<>();
    fireQueue = new LinkedList<>();
    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        space[i][j] = str.charAt(j) + "";
        if (space[i][j].equals("J")) {
          visited[i][j] = 1;
          queue.add(new Dir(i, j, 0));
        }
        if (space[i][j].equals("F")) {
          fireQueue.add(new Dir(i, j, 0));
          visited[i][j] = 2;
        }
        if (space[i][j].equals("#"))
          visited[i][j] = 3;

      }
    }
    bfs();
    if (escape >= 1 && isEscape) {
      System.out.println(escape);
    } else {
      System.out.println("IMPOSSIBLE");
    }
  }

  static void bfs() {
    while (!queue.isEmpty()) {
      Dir jihoon = queue.poll();
      if (jihoon.time == spreadTime) {
        spread();
        spreadTime++;
      }
      if (visited[jihoon.x][jihoon.y] >= 2)
        continue;
      for (int i = 0; i < 4; i++) {
        int nx = jihoon.x + dx[i];
        int ny = jihoon.y + dy[i];
        if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
          escape = jihoon.time + 1;
          isEscape = true;
          return;
        }
        if (nx >= 0 && ny >= 0 && nx < R && ny < C && visited[nx][ny] < 1) {
          queue.add(new Dir(nx, ny, jihoon.time + 1));
          visited[nx][ny] = 1;
        }
      }
    }

  }

  static void spread() {
    int len = fireQueue.size();
    for (int f = 0; f < len; f++) {
      Dir fire = fireQueue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = fire.x + dx[i];
        int ny = fire.y + dy[i];
        if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] >= 2) {
          continue;
        }
        fireQueue.add(new Dir(nx, ny, 0));
        visited[nx][ny] = 2;
      }
    }
  }
}