import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String S;
  static String T;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    S = br.readLine();
    T = br.readLine();

    // 문자열 뒤에 A를 추가
    // 문자열 뒤에 B를 추가하고 문자열을 뒤집음
    System.out.println(recursion(T) ? 1 : 0);

  }

  static boolean recursion(String str) {
    if (str.length() == S.length()) {
      if (str.equals(S)) {
        return true;
      } else {
        return false;
      }
    }
    // dfs(str + "A");
    // StringBuffer sb = new StringBuffer();
    // sb.append(str + "B");
    // sb = sb.reverse();
    // dfs(sb.toString());

    if (str.charAt(str.length() - 1) == 'A') {
      if (recursion(str.substring(0, str.length() - 1))) {
        return true;
      }
    }
    if (str.charAt(0) == 'B') {
      StringBuffer sb = new StringBuffer();
      sb.append(str.substring(1, str.length()));
      if (recursion(sb.reverse().toString())) {
        return true;
      }
    }

    return false;

  }

}