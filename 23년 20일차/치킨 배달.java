import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Chicken {
  int x;
  int y;

  Chicken(int dx, int dy) {
    this.x = dx;
    this.y = dy;
  }
}

public class Main {
  static int N;
  static int M;
  static int[][] city;
  static List<Chicken> chickenList;
  static boolean[] visited;
  static List<Integer> direction;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    city = new int[N + 1][N + 1];
    chickenList = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        city[i][j] = Integer.parseInt(st.nextToken());
        if (city[i][j] == 2) {
          chickenList.add(new Chicken(i, j));
        }
      }
    }
    direction = new ArrayList<>();
    visited = new boolean[chickenList.size()];
    selectChicken(0, 0);

    int min = Integer.MAX_VALUE;

    for (Integer dir : direction) {
      min = Math.min(dir, min);
    }
    System.out.println(min);
  }

  public static void selectChicken(int x, int depth) {
    if (depth == M) {
      calcLength();
      return;
    }
    for (int i = x; i < chickenList.size(); i++) {
      if (!visited[i]) {
        visited[i] = true;
        selectChicken(i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }

  private static void calcLength() {
    Chicken[] arr = new Chicken[M];
    for (int i = 0, j = 0; i < visited.length; i++) {
      if (visited[i]) {
        arr[j] = chickenList.get(i);
        j++;
      }
    }
    int res = 0;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (city[i][j] == 1) {
          int min = Integer.MAX_VALUE;
          for (int k = 0; k < arr.length; k++) {
            int len = Math.abs(arr[k].x - i) + Math.abs(arr[k].y - j);
            min = Math.min(len, min);
          }
          res += min;
        }
      }
    }
    direction.add(res);
  }
}
