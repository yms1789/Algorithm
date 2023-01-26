package jsAlgorithm.23년 3일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int computer = Integer.parseInt(br.readLine());
    int vertex = Integer.parseInt(br.readLine());
    int[][] virusMap = new int[computer + 1][computer + 1];
    boolean[] visited = new boolean[computer + 1];
    visited[0] = true;
    int count = 0;
    for (int i = 0; i < vertex; i++) {
      String[] virus = br.readLine().split(" ");
      int com1 = Integer.parseInt(virus[0]);
      int com2 = Integer.parseInt(virus[1]);
      virusMap[com1][com2] = 1;
      virusMap[com2][com1] = 1;
    }

    Queue<Integer> queue = new LinkedList<>();

    queue.add(1);
    visited[1] = true;

    while (!queue.isEmpty()) {
      int curComputer = queue.remove();
      for (int i = 1; i <= computer; i++) {
        if (virusMap[curComputer][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
    for (int i = 1; i < visited.length; i++) {
      if (visited[i])
        count++;
    }
    System.out.println(count - 1);
  }
}
