import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int change;
  static int maxNum;
  static String[] num;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      num = st.nextToken().split("");
      change = Integer.parseInt(st.nextToken());

      maxNum = Integer.MIN_VALUE;
      if (num.length < change) {
        change = num.length;
      }
      swap(0, 0);
      System.out.println("#" + tc + " " + maxNum);
    }

  }

  static void swap(int x, int depth) {
    if (depth == change) {
      int curNum = Integer.parseInt(String.join("", num));
      if (curNum >= maxNum) {
        maxNum = curNum;
      }
      return;
    }
    for (int i = x; i < num.length; i++) {
      for (int j = i + 1; j < num.length; j++) {
        String temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        swap(i, depth + 1);
        temp = num[j];
        num[j] = num[i];
        num[i] = temp;
      }
    }
  }
}