import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class sw4_findPath {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int tc = 1; tc <= 10; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int test = Integer.parseInt(st.nextToken());
      int len = Integer.parseInt(st.nextToken());
      String[] arr = br.readLine().split(" ");
      int[] node1 = new int[100];
      int[] node2 = new int[100];
      for (int i = 0; i < arr.length; i++) {
        if (i % 2 == 1) {
          if (node1[Integer.parseInt(arr[i - 1])] == 0)
            node1[Integer.parseInt(arr[i - 1])] = Integer.parseInt(arr[i]);
          else {
            node2[Integer.parseInt(arr[i - 1])] = Integer.parseInt(arr[i]);
          }
        }
      }
      int start = 0;
      Stack<Integer> stack = new Stack<>();
      stack.push(0);
      int res = 0;
      while (!stack.isEmpty()) {
        if (stack.contains(99)) {
          res = 1;
          break;
        }
        start = stack.pop();
        if (node1[start] != 0) {
          stack.push(node1[start]);
        }
        if (node2[start] != 0) {
          stack.push(node2[start]);
        }
      }

      System.out.println("#" + test + " " + res);

      // 배열에 각 정점의 좌표를 저장
      // 0부터 시작 -> 각 배열의 요소가 다음 노드의 정점
      // 다음 요소가 안 비어 있을 때 까지 반복
      // 비어있는 요소가 도착점인지 확인

    }

  }
}
// stack: 0 -> 1 -> 2 -> 5 -> 9 -> 8 -> 10
