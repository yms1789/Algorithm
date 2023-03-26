import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static class Dir {
    int x;
    int y;

    public Dir(int dx, int dy) {
      // TODO Auto-generated constructor stub
      this.x = dx;
      this.y = dy;
    }
  }

  static int R, C;
  static int[][] board;
  static boolean[] visited;
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, 1, -1 };
  static int res = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken()); // 행
    C = Integer.parseInt(st.nextToken()); // 열
    board = new int[R][C];
    visited = new boolean[26];
    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        board[i][j] = str.charAt(j) - 'A';
        // 입력받은 알파벳을 숫자로 바꿔가지고 visited를 만든다 -> 생각하기 어려울 것 같음
      }
    }
    dfs(0, new Dir(0, 0));
    System.out.println(res);
  }

  static void dfs(int count, Dir dir) {
    if (visited[board[dir.x][dir.y]]) {
      res = Math.max(count, res);
      return;
    }
    // 이미 해당 알파벳 칸을 방문한 적이 있다면 return 처리
    visited[board[dir.x][dir.y]] = true;
    for (int i = 0; i < 4; i++) {
      int nx = dir.x + dx[i];
      int ny = dir.y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
        dfs(count + 1, new Dir(nx, ny));
      }
    }
    visited[board[dir.x][dir.y]] = false;
  }
}