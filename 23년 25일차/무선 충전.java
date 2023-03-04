import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static class Charger {
    int x;
    int y;
    int coverage;
    int performance;

    public Charger(int x, int y, int cov, int perf) {
      this.x = x;
      this.y = y;
      this.coverage = cov;
      this.performance = perf;
    }
  }

  static int M;
  static int A;
  static int[] userA;
  static int[] userB;
  static Charger[] chargers;
  static int[] dy = { 0, -1, 0, 1, 0 };
  static int[] dx = { 0, 0, 1, 0, -1 };
  static int startAx;
  static int startAy;
  static int startBx;
  static int startBy;
  static int res;

  // 0: 이동 x , 1: 상, 2: 우, 3: 하, 4: 좌
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken()); // 이동 시간
      A = Integer.parseInt(st.nextToken()); // BC 개수
      userA = new int[M];
      userB = new int[M];
      startAx = 1;
      startAy = 1;
      startBx = 10;
      startBy = 10;
      res = 0;
      chargers = new Charger[A];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        userA[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        userB[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i < A; i++) {
        st = new StringTokenizer(br.readLine());
        chargers[i] = new Charger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      }
      move();
      System.out.println("#" + tc + " " + res);
    }
  }

  public static void move() {
    for (int i = -1; i < M; i++) {// 이동 시간
      if (i != -1) {
        startAx += dx[userA[i]];
        startAy += dy[userA[i]];
        startBx += dx[userB[i]];
        startBy += dy[userB[i]];
      }
      int[][] useCharger = new int[2][A];

      for (int j = 0; j < A; j++) { // BC 개수에 따른 충전
        if (calcLength(startBx, startBy, j)) {
          useCharger[1][j] += 1;
        }
        if (calcLength(startAx, startAy, j)) {
          useCharger[0][j] += 1;
        }
      }

      int sum = 0;
      for (int k = 0; k < A; k++) {
        for (int l = 0; l < A; l++) {
          int temp = 0;
          if (useCharger[0][k] == 1) {
            if (useCharger[1][l] == 1) {
              if (k == l) {
                temp = chargers[k].performance;
              } else {
                temp = chargers[k].performance + chargers[l].performance;
              }
            } else {
              temp = chargers[k].performance;
            }
          } else {
            if (useCharger[1][l] == 1) {
              temp = chargers[l].performance;
            }
          }
          sum = Math.max(sum, temp);
        }
      }
      res += sum;
    }

  }

  public static boolean calcLength(int x, int y, int charger) {
    if (Math.abs(chargers[charger].x - x) + Math.abs(chargers[charger].y - y) <= chargers[charger].coverage) {
      return true;
    }
    return false;
  }
}
