import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
  static int N, M;
  static String[][] map;
  static HashMap<String, Integer> patterns;
  static int sum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      map = new String[N][M];
      for (int i = 0; i < N; i++) {
        map[i] = br.readLine().split("");
      }

      patterns = new HashMap<>();
      patterns.put("3211", 0);
      patterns.put("2221", 1);
      patterns.put("2122", 2);
      patterns.put("1411", 3);
      patterns.put("1132", 4);
      patterns.put("1231", 5);
      patterns.put("1114", 6);
      patterns.put("1312", 7);
      patterns.put("1213", 8);
      patterns.put("3112", 9);

      // 가장 뒷자리는 무조건 1 뒤에서부터 시작해서 1 -> 56개가 암호
      int[] dir = findStart();
      StringBuffer sb = new StringBuffer();
      for (int i = dir[1]; sb.toString().length() < 56; i--) {
        sb.append(map[dir[0]][i]);
      }
      String password = sb.reverse().toString();
      int[] code = new int[8];
      for (int i = 0, idx = 0; i < password.length(); idx++) {
        String subPassword = password.substring(i, i + 7);
        code[idx] = findPattern(subPassword);
        i += 7;
      }
      // System.out.println(Arrays.toString(code));
      int oddSum = 0;
      int evenSum = 0;
      sum = 0;
      for (int i = 0; i < code.length; i++) {
        if (i % 2 == 0) {// 짝수
          evenSum += code[i];
        } else {
          oddSum += code[i];
        }
      }
      sum = evenSum * 3 + oddSum;
      if (sum % 10 == 0) {
        int res = 0;
        for (int i = 0; i < code.length; i++) {
          res += code[i];
        }
        System.out.println("#" + tc + " " + res);
      } else {
        System.out.println("#" + tc + " " + 0);
      }
    }
  }

  static int[] findStart() {
    int[] idx = new int[2];
    for (int i = 0; i < N; i++) {
      for (int j = M - 1; j >= 0; j--) {
        if (map[i][j].equals("1")) {
          idx[0] = i;
          idx[1] = j;
          return idx;
        }
      }
    }
    return idx;
  }

  static int findPattern(String password) {
    char start = password.charAt(0);
    String pattern = "";
    int count = 1;
    for (int i = 1; i < password.length(); i++) {
      if (start != password.charAt(i)) {
        pattern += count;
        count = 1;
        start = password.charAt(i);
      } else {
        count++;
      }

    }
    pattern += count;
    // System.out.println(pattern);
    return patterns.get(pattern);
  }
}