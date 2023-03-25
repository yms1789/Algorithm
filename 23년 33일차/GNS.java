import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
  static int[] sortedNum;
  static String[] str;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    for (int tc = 1; tc <= T; tc++) {
      StringBuffer sb = new StringBuffer();
      sb.append("#").append(tc).append("\n");
      int len = Integer.parseInt(br.readLine().split(" ")[1]);
      str = new String[len];
      str = br.readLine().split(" ");
      sortedNum = new int[len];
      for (int i = 0; i < len; i++) {
        sortedNum[i] = translate(str[i]);
      }
      Arrays.sort(sortedNum);
      for (int i = 0; i < sortedNum.length; i++) {
        sb.append(retrans(sortedNum[i])).append(" ");
      }
      System.out.println(sb.toString().trim());
    }

  }

  static int translate(String str) {
    switch (str) {
      case "ZRO":
        return 0;
      case "ONE":
        return 1;
      case "TWO":
        return 2;
      case "THR":
        return 3;
      case "FOR":
        return 4;
      case "FIV":
        return 5;
      case "SIX":
        return 6;
      case "SVN":
        return 7;
      case "EGT":
        return 8;
      case "NIN":
        return 9;
      default:
        return -1;
    }
  }

  static String retrans(int num) {
    switch (num) {
      case 0:
        return "ZRO";
      case 1:
        return "ONE";
      case 2:
        return "TWO";
      case 3:
        return "THR";
      case 4:
        return "FOR";
      case 5:
        return "FIV";
      case 6:
        return "SIX";
      case 7:
        return "SVN";
      case 8:
        return "EGT";
      case 9:
        return "NIN";
      default:
        return "";
    }
  }

}
