import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int[] sequence = new int[N];
    for (int i = 0; i < N; i++) {
      M = Integer.parseInt(br.readLine());
      sequence[i] = M;
    }
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int fill = 0;
    for (int i = 1; i <= N; i++) {
      stack.push(i);
      sb.append("+").append("\n");
      if (sequence[fill] == i) {
        stack.pop();
        sb.append("-").append("\n");
        fill++;
        if (stack.size() > 0) {
          while (stack.peek() == sequence[fill]) {
            stack.pop();
            sb.append("-").append("\n");
            fill++;
            if (fill >= N || stack.isEmpty()) {
              break;
            }
          }
        }
      }
    }
    if (stack.isEmpty()) {
      System.out.println(sb);
    } else {
      System.out.println("NO");
    }
  }
}

// 1 2 5 7 8
// 4 3 6 8 7 5 2 1
// 1 2 3 4 5
//