import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 혼자 해결 X
public class Main {
  static int N;
  static int M;
  static int[][] room; // 0: 청소 X, 1: 청소 O
  static int d; // 0: 북, 1: 동, 2: 남, 3: 서
  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, 1, 0, -1 };

  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int roboX = Integer.parseInt(st.nextToken());
    int roboY = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    room = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    cleanRoom(roboX, roboY, d);
    System.out.println(count);
  }

  public static void cleanRoom(int x, int y, int dir) {
    if (room[x][y] == 0) {
      room[x][y] = 2;
      count++;
    }
    int flag = 0;
    int orginDir = dir;
    for (int i = 0; i < 4; i++) {
      int nd = (dir + 3) % 4;
      int nx = x + dx[nd];
      int ny = y + dy[nd];
      if (nx > 0 && ny > 0 && nx < N && ny < M) {
        if (room[nx][ny] == 0) {
          cleanRoom(nx, ny, nd);
          flag = 1;
          break;
        }
      }
      dir = nd;
    }
    if (flag == 0) {
      int nd = (orginDir + 2) % 4;
      int bx = x + dx[nd];
      int by = y + dy[nd];
      if (bx > 0 && by > 0 && bx < N && by < M) {
        if (room[bx][by] != 1) {
          cleanRoom(bx, by, orginDir);
        }
      }
    }
  }
}