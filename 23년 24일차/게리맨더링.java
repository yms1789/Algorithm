import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] population;
  static boolean[] visited;
  static int popA;
  static int popB;
  static int diff = Integer.MAX_VALUE;
  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    population = new int[N + 1];
    visited = new boolean[N + 1];
    map = new int[N + 1][N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      population[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int count = Integer.parseInt(st.nextToken());
      for (int j = 0; j < count; j++) {
        int conn = Integer.parseInt(st.nextToken());
        map[i][j] = conn;

      }
    }

    dfs(1);
    System.out.println(diff == Integer.MAX_VALUE ? -1 : diff);
  }

  public static void dfs(int idx) {
    if (N + 1 == idx) {
      if (checkConn()) {
        calcPopulation();
      }
      return;
    }

    visited[idx] = true;
    dfs(idx + 1);
    visited[idx] = false;
    dfs(idx + 1);

  }

  public static boolean checkConn() {
    int[] areaA = new int[N];
    int[] areaB = new int[N];
    int areaAIdx = 0;
    int areaBIdx = 0;
    boolean[] checked = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      if (visited[i]) {
        areaA[areaAIdx] = i;
        areaAIdx++;
      } else {
        areaB[areaBIdx] = i;
        areaBIdx++;
      }
    }
    if (areaAIdx == 0 || areaBIdx == 0)
      return false;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(areaA[0]);
    checked[areaA[0]] = true;
    while (!queue.isEmpty()) {
      int select = queue.poll();
      for (int i = 0; i < map[select].length; i++) {
        if (checked[map[select][i]])
          continue;
        if (!visited[map[select][i]])
          continue;
        checked[map[select][i]] = true;
        queue.offer(map[select][i]);
      }
    }

    queue.offer(areaB[0]);
    checked[areaB[0]] = true;
    while (!queue.isEmpty()) {
      int select = queue.poll();
      for (int i = 0; i < map[select].length; i++) {
        if (checked[map[select][i]])
          continue;
        if (visited[map[select][i]])
          continue;
        checked[map[select][i]] = true;
        queue.offer(map[select][i]);
      }
    }
    for (int i = 1; i <= N; i++) {
      if (!checked[i])
        return false;
    }
    return true;
  }

  public static void calcPopulation() {
    popA = 0;
    popB = 0;
    for (int i = 1; i <= N; i++) {
      if (visited[i])
        popA += population[i];
      else
        popB += population[i];
    }
    diff = Math.min(Math.abs(popA - popB), diff);
  }
}