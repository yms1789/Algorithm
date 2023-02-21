import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw3_palindrome {
  static int N;
  static int count;
  static String[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int tc = 1; tc <= 10; tc++) {
      N = Integer.parseInt(br.readLine());
      arr = new String[8][8];
      count = 0;
      for (int i = 0; i < 8; i++) {
        arr[i] = br.readLine().split("");
      }

      for (int i = 0; i < 8; i++) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < 8; j++) {
          sb.append(arr[i][j]);
          if (sb.length() > N) {
            sb.delete(0, 1);
          }
          if (sb.length() == N) {
            isPalindrome(sb);
          }
        }
      }
      for (int i = 0; i < 8; i++) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < 8; j++) {
          sb.append(arr[j][i]);
          if (sb.length() > N) {
            sb.delete(0, 1);
          }
          if (sb.length() == N) {
            isPalindrome(sb);
          }
        }
      }
      System.out.println("#" + tc + " " + count);
    }
  }

  public static void isPalindrome(StringBuffer sb) {
    String str1 = sb.toString();
    String reverseStr1 = sb.reverse().toString();
    sb.reverse();
    if (str1.equals(reverseStr1)) {
      count++;
    }
  }
}
