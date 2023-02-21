import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw3_String {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int tc = 1; tc <= 10; tc++) {
      int test = Integer.parseInt(br.readLine());
      String keyword = br.readLine();
      StringBuffer sb = new StringBuffer();
      int count = 0;
      sb.append(br.readLine());
      for (int i = 0; i <= sb.length() - keyword.length(); i++) {
        System.out.print(sb.substring(i, i + keyword.length()) + " ");
        if (sb.substring(i, i + keyword.length()).equals(keyword)) {
          count++;
        }
        ;
      }
      System.out.println("#" + test + " " + count);
    }
  }
}
