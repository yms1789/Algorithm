
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  static String[] stick;

  public static void main(String[] args) throws IOException {
    // "()"는 레이저
    // "( ~ ) 까지가 쇠 막대기"
    // 반복문: 여는 괄호면 스택에 넣기, 레이저면 스택 안에 여는 괄호 개수 구해서 + result
    // 닫는 괄호면 + 1
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    stick = br.readLine().split("");
    Stack<String> stack = new Stack<>();
    int result = 0;
    for (int i = 0; i < stick.length; i++) {
      if (stick[i].equals("(")) {
        stack.push(stick[i]);
      } else if (stick[i].equals(")")) {
        stack.pop();
        if (stick[i - 1].equals("(")) {
          result += stack.size();
        } else {
          result += 1;
        }
      }
    }
    System.out.println(result);
  }
}
