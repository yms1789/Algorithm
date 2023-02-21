import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class sw3_palindrome3 {
  static List<String> palindromeList;
  static int N;
  static String[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int tc = 1; tc <= 10; tc++) {
      N = Integer.parseInt(br.readLine());
      arr = new String[100][100];
      palindromeList = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
        arr[i] = br.readLine().split("");
      }
      int rowPal = 1;
      int colPal = 1;
      while (rowPal <= 100) {
        for (int i = 0; i < 100; i++) {
          StringBuffer sb = new StringBuffer();
          for (int j = 0; j < 100; j++) {
            sb.append(arr[i][j]);
            if (sb.length() > rowPal) {
              sb.delete(0, 1);
            }
            if (sb.length() == rowPal) {
              isPalindrome(sb);
            }
          }
        }
        rowPal++;
      }
      while (colPal <= 100) {
        for (int i = 0; i < 100; i++) {
          StringBuffer sb = new StringBuffer();
          for (int j = 0; j < 100; j++) {
            sb.append(arr[j][i]);
            if (sb.length() > colPal) {
              sb.delete(0, 1);
            }
            if (sb.length() == colPal) {
              isPalindrome(sb);
            }
          }
        }
        colPal++;
      }
      int maxLength = 0;
      for (String palindrome : palindromeList) {
        maxLength = Math.max(palindrome.length(), maxLength);
      }
      System.out.println("#" + tc + " " + maxLength);
    }
  }

  public static void isPalindrome(StringBuffer sb) {
    String str1 = sb.toString();
    String reverseStr1 = sb.reverse().toString();
    sb.reverse();
    if (str1.equals(reverseStr1)) {
      palindromeList.add(str1);
    }
  }
}
