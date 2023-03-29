import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] space;
  static int N, K;
  static Queue<Integer> queue;
  static boolean[] visited;
  static int[] dx = { -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    space = new int[100001];
    visited = new boolean[100001];
    queue = new LinkedList<>();
    queue.add(N);
    space[N] = 0;
    visited[N] = true;

    if (N == K) {
      System.out.println(space[K]);
      return;
    } else {
      while (!queue.isEmpty()) {
        int cur = queue.poll();
        for (int i = 0; i < 3; i++) {
          int nx;
          if (i == 2) {
            nx = 2 * cur;
          } else {
            nx = cur + dx[i];
          }
          if (nx < 0 || nx >= space.length || visited[nx])
            continue;
          if (nx == K) {
            space[K] = space[cur] + 1;
            System.out.println(space[K]);
            return;
          }
          queue.add(nx);
          visited[nx] = true;
          space[nx] = space[cur] + 1;

        }
      }
    }

  }
}
