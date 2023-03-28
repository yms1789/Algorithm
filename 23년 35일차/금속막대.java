import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int N;
  static int[][] screw;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      N = Integer.parseInt(br.readLine());
      screw = new int[N][2];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        screw[i][0] = Integer.parseInt(st.nextToken()); // 수나사
        screw[i][1] = Integer.parseInt(st.nextToken()); // 암나사
      }
      boolean flag;
      int position = 0;
      // 수나사가 암나사에 맞지 않는 막대 찾기
      for (int i = 0; i < N; i++) {
        flag = false;
        for (int j = 0; j < N; j++) {
          if (i == j)
            continue;
          if (screw[i][0] == screw[j][1]) {
            flag = true;
            break;
          }
        }
        // i번째 막대 수나사가 다른 막대 암나사랑
        // 맞는 게 없다면 postion을 i번째 막대 인덱스로 바꿔줌
        if (!flag) {
          position = i;
        }
      }
      StringBuffer sb = new StringBuffer();
      sb.append(screw[position][0] + " " + screw[position][1] + " ");
      int cur = 0;
      while (N > 1) {
        if (cur == position) {
          cur++;
          continue;
        }

        if (screw[cur][0] == screw[position][1]) {
          sb.append(screw[cur][0] + " " + screw[cur][1] + " ");
          position = cur;
          cur = 0;
          N--;
        } else {
          cur++;
        }
      }
      System.out.println("#" + tc + " " + sb.toString());
    }
  }
}

/*
 * 테스트케이스 결과는 모든 막대가 다 연결되어있음
 * (문제에는 최대로 연결할 수 있는 경우를 찾으라고 되어있는데...)
 * 제일 첫번째 막대를 찾기(금속막대 중 수나사가 암나사랑 안맞는 막대)
 * 첫번째 막대를 놓고 N = 0이 될 때 까지 막대를 맞춰나가자!
 * (N번째 막대 암나사랑 N+1번째 막대 수나사랑 맞는 비교)
 * 
 */
