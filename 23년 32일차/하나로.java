import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
  // 최소 신장 트리 알고리즘으로 해결해야 함
  // Prim, Kruskal
  static int N;
  static double E;
  static long minCost;
  static Dir[] islands;
  static ArrayList<Edge> edgeList;
  static int[] parents;

  static class Dir {
    int x;
    int y;

    Dir() {
      this.x = 0;
      this.y = 0;
    }
  }

  static class Edge implements Comparable<Edge> {
    int from, to;
    long w;

    public Edge(int from, int to, long w) {
      this.from = from;
      this.to = to;
      this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
      // TODO Auto-generated method stub
      return Long.compare(this.w, o.w);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      N = Integer.parseInt(br.readLine());

      islands = new Dir[N];
      parents = new int[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        islands[i] = new Dir();
        islands[i].x = Integer.parseInt(st.nextToken());

      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        islands[i].y = Integer.parseInt(st.nextToken());
      }
      E = Double.parseDouble(br.readLine());

      edgeList = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
          long distX = Math.abs(islands[i].x - islands[j].x);
          long distY = Math.abs(islands[i].y - islands[j].y);
          edgeList.add(new Edge(i, j, distX * distX + distY * distY));
        }
      }
      edgeList.sort(null);
      for (int i = 0; i < N; i++) {
        parents[i] = i;
      }
      // 가중치가 낮은 간선부터 선택하면서 트리에 추가
      int cnt = 0;
      long res = 0;
      for (Edge edge : edgeList) {
        // 싸이클이 형성되지 않으면
        if (union(edge.from, edge.to)) {
          // 간선 사용
          res += edge.w;
          if (++cnt == N - 1)
            break;
        }
      }
      System.out.println("#" + tc + " " + Math.round(res * E));
    }
  }

  static boolean union(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);
    // 사이클이 형성되면
    if (aRoot == bRoot)
      return false;
    parents[bRoot] = aRoot;
    return true;
  }

  static int find(int a) {
    if (a == parents[a])
      return a;
    return parents[a] = find(parents[a]);
  }
}