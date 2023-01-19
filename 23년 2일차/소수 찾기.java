import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int count = 0;
    boolean[] prime = new boolean[1001];
    prime[1] = true;
    for (int i = 2; i * i <= 1000; i++) {
      if (prime[i])
        continue;
      for (int j = i * i; j <= 1000; j += i) {
        prime[j] = true;
      }
    }

    for (int i = 0; i < N; i++) {
      int inputNum = Integer.parseInt(st.nextToken());
      if (!prime[inputNum]) {
        count++;
      }
    }

    System.out.println(count);
  }
}
