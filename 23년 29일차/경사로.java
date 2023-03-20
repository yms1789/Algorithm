import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int L;
  static boolean[] visited;
  static int[][] map;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    // 경사로는 높이가 항상 1, 길이는 L -> 높은 칸과 낮은 칸을 연결
    /*
     * 경사로 연결 조건 경사로는 낮은 칸에 놓음, L개의 연속된 칸에 경사로 바닥이 모두 접해야 함 낮은 칸 <-> 높은 칸의 높이 차는
     * 1이어야 함 경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고 L개 칸이 연속되어 있어야 함
     */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    map = new int[N][N];
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
      if (findCol(i))
        count++;
    }
    System.out.println(count);

  }

  static boolean findRow(int row) {
    boolean[] visited = new boolean[N];
    for (int i = 0; i < N - 1; i++) {
      int diff = map[row][i] - map[row][i + 1];
      if (diff < -1 || diff > 1) {
        return false;
      } else if (diff == 1) { // 이전 칸이 더 높음
        for (int j = 1; j <= L; j++) {
          if (i + j >= N || visited[i + j])
            return false;
          if (map[row][i] - 1 != map[row][i + j])
            return false;
          visited[i + j] = true;
        }
      } else if (diff == -1) { // 다음 칸이 더 높음
        for (int j = 0; j < L; j++) {
          if (i - j < 0 || visited[i - j]) // 경사로가 설치되어 있거나 범위를 벗어나는 경우
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
      } else if (diff == 1) { // 이전 칸이 더 높음
        for (int j = 1; j <= L; j++) {
          if (i + j >= N || visited[i + j])
            return false;
          if (map[i][col] - 1 != map[i + j][col])
            return false;
          visited[i + j] = true;
        }
      } else if (diff == -1) { // 다음 칸이 더 높음
        for (int j = 0; j < L; j++) {
          if (i - j < 0 || visited[i - j]) // 경사로가 설치되어 있거나 범위를 벗어나는 경우
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