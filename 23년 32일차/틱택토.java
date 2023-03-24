import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    while (!(str = br.readLine()).equals("end")) {
      board = new String[3][3];
      for (int i = 0, j = 0; i < 3; i++, j += 3) {
        board[i] = str.substring(j, j + 3).split("");
      }
      // X 개수랑 O 개수는 최대 한 개 차이가 날 수 있음
      // X가 이겼을 땐 X가 1개 많아야 함
      // O가 이겼을 떈 X 개수 O개수 같아야 함
      // 둘이 비겼을 때도 X, O 개수 같아야 함
      if (isValid()) {
        System.out.println("valid");
      } else {
        System.out.println("invalid");
      }
    }
  }

  static boolean isValid() {
    int xCount = 0;
    int oCount = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j].equals("X")) {
          xCount++;
        }
        if (board[i][j].equals("O")) {
          oCount++;
        }
      }
    }
    if (xCount < oCount)
      return false;
    if (xCount + oCount == 9 && xCount == oCount + 1) {
      // 놓을 말이 없는 경우
      if (isWin("O")) {
        return false;
      } else {
        return true;
      }
    } else {
      // 아직 말이 남은 경우
      if (isWin("O") && !isWin("X")) {
        if (xCount == oCount)
          return true;
        else
          return false;
      }
      if (isWin("X") && !isWin("O")) {
        if (xCount - oCount == 1)
          return true;
        else
          return false;
      }

    }
    return false;
  }

  static boolean isWin(String c) {
    // 가로 비교
    for (int i = 0; i < 3; i++) {
      if (board[i][0].equals(c) && board[i][1].equals(c) && board[i][2].equals(c)) {
        return true;
      }
    }
    // 세로 비교
    for (int i = 0; i < 3; i++) {
      if (board[0][i].equals(c) && board[1][i].equals(c) && board[2][i].equals(c)) {
        return true;
      }
    }
    // 대각선 비교
    if (board[0][0].equals(c) && board[1][1].equals(c) && board[2][2].equals(c)) {
      return true;
    }

    if (board[2][0].equals(c) && board[1][1].equals(c) && board[0][2].equals(c)) {
      return true;
    }

    return false;
  }
}