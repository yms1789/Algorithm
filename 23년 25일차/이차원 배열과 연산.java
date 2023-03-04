import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static class Pair implements Comparable<Pair> {
    int number;
    int count;

    Pair(int num, int cnt) {
      this.number = num;
      this.count = cnt;
    }

    @Override
    public int compareTo(Pair o) {
      // TODO Auto-generated method stub
      if (this.count > o.count)
        return 1;
      else if (this.count == o.count) {
        return this.number - o.number;
      } else
        return -1;
    }
  }

  static int[][] arr;
  static List<Integer[]> sortArr;
  static int r, c, k;
  static int row = 3;
  static int col = 3;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[101][101];
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    int res = -1;
    for (int i = 1; i <= 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int t = 0; t <= 100; t++) {
      if (arr[r][c] == k) {
        res = t;
        break;
      }
      if (row >= col) {
        for (int i = 1; i <= row; i++) {
          PriorityQueue<Pair> pq = new PriorityQueue<>();
          Map<Integer, Integer> map = new HashMap<>();

          for (int j = 1; j <= col; j++) {
            if (arr[i][j] == 0)
              continue;
            map.compute(arr[i][j], (num, count) -> count == null ? 1 : count + 1);
          }
          map.forEach((key, val) -> pq.add(new Pair(key, val)));
          int idx = 1;
          while (!pq.isEmpty()) {
            Pair p = pq.poll();
            arr[i][idx++] = p.number;
            arr[i][idx++] = p.count;
          }
          col = Math.max(col, idx);
          while (idx <= 99) {
            arr[i][idx++] = 0;
            arr[i][idx++] = 0;
          }
        }
      } else {
        for (int i = 1; i <= col; i++) {
          PriorityQueue<Pair> pq = new PriorityQueue<>();
          Map<Integer, Integer> map = new HashMap<>();

          for (int j = 1; j <= col; j++) {
            if (arr[j][i] == 0)
              continue;
            map.compute(arr[j][i], (num, count) -> count == null ? 1 : count + 1);
          }
          map.forEach((key, val) -> pq.add(new Pair(key, val)));
          int idx = 1;
          while (!pq.isEmpty()) {
            Pair p = pq.poll();
            arr[idx++][i] = p.number;
            arr[idx++][i] = p.count;
          }
          row = Math.max(row, idx);
          while (idx <= 99) {
            arr[idx++][i] = 0;
            arr[idx++][i] = 0;
          }
        }
      }
    }
    System.out.println(res);
  }
}
