import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class sw4_password {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int tc = 1; tc <= 10; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      String password = st.nextToken();
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < N; i++) {
        if (stack.isEmpty()) {
          stack.push(password.charAt(i));
          continue;
        } else {
          if (stack.peek() == password.charAt(i)) {
            stack.pop();
            continue;
          } else {
            stack.push(password.charAt(i));
          }
        }
      }
      StringBuffer sb = new StringBuffer();
      for (Character ch : stack) {
        sb.append(ch);
      }
      System.out.println("#" + tc + " " + sb.toString());
    }
  }
}
