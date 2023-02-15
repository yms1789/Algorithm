import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        if (Math.abs(a) > Math.abs(b))
          return Math.abs(a) - Math.abs(b); // 양수면 b가 더 작음 => b가 위, 음수면 a가 더 작음 => a가 위
        else if (Math.abs(a) == Math.abs(b))
          return a - b;
        else {
          return -1;
        }
      }
    });
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int M = Integer.parseInt(br.readLine());
      if (M == 0) {
        if (pq.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(pq.poll()).append("\n");
        }
      } else {
        pq.offer(M);
      }
    }
    System.out.println(sb);
  }
}
