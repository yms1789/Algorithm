import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
  static int N, K;
  static String[][] numberArr;
  static Set<String> numSet;
  static List<Integer> numberList;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      numberArr = new String[4][N / 4];
      String numbers = br.readLine();
      int idx = 0;
      numSet = new HashSet<>();
      for (int i = 0; i < 4; i++) {
        numberArr[i] = numbers.substring(idx, idx + (N / 4)).split("");
        idx += N / 4;
        numSet.add(String.join("", numberArr[i]));

      }
      String start = String.join("", numberArr[0]);
      String[] flat = Arrays.stream(numberArr).flatMap(Arrays::stream).toArray(String[]::new);
      for (int i = 0;; i++) {
        String lastNum = flat[flat.length - 1];
        int flatIdx = 0;
        for (int j = flat.length - 1; j >= 1; j--) {
          flat[j] = flat[j - 1];
        }
        flat[0] = lastNum;
        for (int j = 0; j < 4; j++) {
          String flatString = String.join("", flat);
          numberArr[j] = flatString.substring(flatIdx, flatIdx + (N / 4)).split("");
          flatIdx += N / 4;
          numSet.add(String.join("", numberArr[j]));
        }
        if (start.equals(String.join("", numberArr[0]))) {
          break;
        }
      }
      numberList = new ArrayList<>();
      for (String str : numSet) {
        numberList.add(Integer.parseInt(str, 16));
      }
      Collections.sort(numberList, Collections.reverseOrder());
      System.out.println("#" + tc + " " + numberList.get(K - 1));

    }
  }
}