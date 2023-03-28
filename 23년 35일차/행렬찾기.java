import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
  static class Matrix implements Comparable<Matrix> {
    int row;
    int col;
    int size;

    Matrix(int dx, int dy, int size) {
      this.row = dx;
      this.col = dy;
      this.size = size;
    }

    @Override
    public int compareTo(Matrix o) {
      if (size < o.size)
        return -1;
      else if (size == o.size)
        return col < o.col ? -1 : 1;
      else
        return 1;
    }
  }

  static int N;
  static int[][] map;
  static boolean[][] visited;
  static LinkedList<Matrix> arr;
  static int[] dx = { -1, 1, 0, 0 }; // 상 하 우 좌
  static int[] dy = { 0, 0, 1, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      N = Integer.parseInt(br.readLine());
      map = new int[N][N];
      visited = new boolean[N][N];
      arr = new LinkedList<Matrix>();
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] != 0 && !visited[i][j]) {
            searchMatrix(i, j, 1, 1);
          }
        }
      }
      Collections.sort(arr);
      StringBuffer sb = new StringBuffer();
      sb.append("#").append(tc).append(" ").append(arr.size());
      for (Matrix mat : arr) {
        sb.append(" " + mat.col + " " + mat.row);
      }
      sb.append("\n");
      System.out.print(sb.toString());
    }

  }

  static void searchMatrix(int x, int y, int row, int col) {
    visited[x][y] = true;
    if ((x + 1 == N || map[x + 1][y] == 0) && (y + 1 == N || map[x][y + 1] == 0)) {
      arr.add(new Matrix(col, row, row * col));
    }
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
        continue;
      }
      if (map[nx][ny] == 0)
        continue;
      // 상 하 우 좌
      if (i == 0)
        searchMatrix(nx, ny, row - 1, col);
      else if (i == 1)
        searchMatrix(nx, ny, row + 1, col);
      else if (i == 2)
        searchMatrix(nx, ny, row, col + 1);
      else
        searchMatrix(nx, ny, row, col - 1);
    }

  }
}
