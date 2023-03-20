import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
  static int N, M;
  static int[][] map;
  static HashMap<String, Integer> patterns;
  static int sum;
  static int[][] hcode = { { 0, 0, 0, 0 }, // 0
      { 0, 0, 0, 1 }, // 1
      { 0, 0, 1, 0 }, // 2
      { 0, 0, 1, 1 }, // 3
      { 0, 1, 0, 0 }, // 4
      { 0, 1, 0, 1 }, // 5
      { 0, 1, 1, 0 }, // 6
      { 0, 1, 1, 1 }, // 7
      { 1, 0, 0, 0 }, // 8
      { 1, 0, 0, 1 }, // 9
      { 1, 0, 1, 0 }, // A
      { 1, 0, 1, 1 }, // B
      { 1, 1, 0, 0 }, // C
      { 1, 1, 0, 1 }, // D
      { 1, 1, 1, 0 }, // E
      { 1, 1, 1, 1 }, // F
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      map = new int[N][M * 4];
      for (int i = 0; i < N; i++) {
        String str = br.readLine();
        for (int j = 0; j < M; j++) {
          char c = str.charAt(j);
          int num = Character.digit(c, 16);
          for (int k = 0; k < 4; k++) {
            map[i][j * 4 + k] = hcode[num][k];
          }
        }
      }
      int codeLen = 7;
      int res = 0;
      int[] codes = new int[8]; // 암호코드 8개의 숫자를 담을 공간.
      patterns = new HashMap<>();
      patterns.put("211", 0);
      patterns.put("221", 1);
      patterns.put("122", 2);
      patterns.put("411", 3);
      patterns.put("132", 4);
      patterns.put("231", 5);
      patterns.put("114", 6);
      patterns.put("312", 7);
      patterns.put("213", 8);
      patterns.put("112", 9);
      for (int i = 1; i < N; i++) {
        for (int j = M * 4 - 1; j >= 0; j--) {
          if (map[i][j] == 1 && map[i - 1][j] == 0) {
            // System.out.println(Arrays.toString(map[i]));
            int x, y, z;
            x = y = z = 0;

            while (map[i][j] == 1) {
              z++;
              j--;
            }
            while (map[i][j] == 0) {
              y++;
              j--;
            }
            while (map[i][j] == 1) {
              x++;
              j--;
            }
            if (codeLen != 0) {
              while (map[i][j] == 0) {
                j--;
              }
            }
            j++;
            int min_xyz = Math.min(Math.min(x, y), z);
            x = x / min_xyz;
            y = y / min_xyz;
            z = z / min_xyz;
            String pattern = "" + x + y + z;
            codes[codeLen--] = patterns.get(pattern);
            if (codeLen == -1) {
              int oddSum = 0;
              int evenSum = 0;
              sum = 0;
              for (int k = 0; k < codes.length - 1; k++) {
                if (k % 2 == 0) {// 짝수
                  evenSum += codes[k];
                } else {
                  oddSum += codes[k];
                }
              }
              sum = evenSum * 3 + oddSum + codes[codes.length - 1];
              if (sum % 10 == 0) {

                for (int k = 0; k < codes.length; k++) {
                  res += codes[k];
                }
              }
              codeLen = 7;
            }
          }
        }
      }
      System.out.println("#" + tc + " " + res);
      // System.out.println(Arrays.toString(codes));

    }
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