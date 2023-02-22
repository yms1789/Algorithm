import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class sw4_bracket {
  static String open = "{([<";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int tc = 1; tc <= 10; tc++) {
      int len = Integer.parseInt(br.readLine());
      String[] arr = br.readLine().split("");
      Stack<String> stack = new Stack<>();
      for (int i = 0; i < arr.length; i++) {
        if (open.contains(arr[i])) {
          stack.push(arr[i]);
          continue;
        } else {
          if (arr[i].equals(")") && stack.peek().equals("(")) {
            stack.pop();
          } else if (arr[i].equals("]") && stack.peek().equals("[")) {
            stack.pop();
          } else if (arr[i].equals("}") && stack.peek().equals("{")) {
            stack.pop();
          } else if (arr[i].equals(">") && stack.peek().equals("<")) {
            stack.pop();
          } else {
            stack.push(arr[i]);
          }
        }
      }
      int res = 0;
      if (stack.isEmpty()) {
        res = 1;
      }
      System.out.println("#" + tc + " " + res);
    }
  }
}
