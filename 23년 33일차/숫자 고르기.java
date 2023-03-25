import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  static int[] table;
  static int N;
  static boolean[] visited;
  static List<Integer> choice;

  // static List<Integer> list2;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    table = new int[N + 1];
    visited = new boolean[N + 1];
    choice = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      table[i] = Integer.parseInt(br.readLine());
    }
    for (int i = 1; i <= N; i++) {
      visited[i] = true;
      dfs(i, i);
      visited[i] = false;
    }
    Collections.sort(choice);
    System.out.println(choice.size());
    for (int num : choice) {
      System.out.println(num);
    }
  }

  static void dfs(int start, int idx) {
    if (table[start] == idx)
      choice.add(idx);
    if (!visited[table[start]]) {
      visited[table[start]] = true;
      dfs(table[start], idx);
      visited[table[start]] = false;
    }
  }
}
