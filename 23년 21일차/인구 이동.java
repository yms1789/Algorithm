import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Union {
  int x;
  int y;

  Union(int dx, int dy) {
    this.x = dx;
    this.y = dy;
  }
}

public class Main {
  static int N;
  static int L;
  static int R;
  static int[][] ground;
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, 1, -1 };
  static Queue<Union> queue;
  static boolean[][] visited;
  static List<Union> list;
  // 하, 상, 우, 좌

  // 인구수 : (연합의 인구수) / (연합을 이루고 있는 칸의 개수)

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    ground = new int[N][N];
    for (int i = 0; i < N; i++) {

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        ground[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int count = 0;
    while (true) {
      visited = new boolean[N][N];
      boolean flag = false;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j]) {
            bfs(i, j);
            if (list.size() > 1) {
              flag = true;
            }
          }
        }
      }
      if (flag == false)
        break;
      count++;
    }
    System.out.println(count);
  }

  static void bfs(int x, int y) {
    list = new ArrayList<>();

    queue = new LinkedList<>();
    queue.offer(new Union(x, y));
    list.add(new Union(x, y));
    visited[x][y] = true;
    int totalPopulation = ground[x][y];
    while (!queue.isEmpty()) {
      Union curCountry = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curCountry.x + dx[i];
        int ny = curCountry.y + dy[i];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N)
          continue;
        if (visited[nx][ny] == false && Math.abs(ground[curCountry.x][curCountry.y] - ground[nx][ny]) >= L
            && Math.abs(ground[curCountry.x][curCountry.y] - ground[nx][ny]) <= R) {
          queue.add(new Union(nx, ny));
          list.add(new Union(nx, ny));
          totalPopulation += ground[nx][ny];
          visited[nx][ny] = true;
        }
      }
    }
    if (list.size() > 1) {
      for (Union country : list) {
        ground[country.x][country.y] = totalPopulation / list.size();
      }
    }

  }
}
