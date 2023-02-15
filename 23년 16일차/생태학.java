import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double result = 0;
    TreeMap<String, Integer> map = new TreeMap<>();
    String str = br.readLine();
    while (true) {
      map.put(str, map.getOrDefault(str, 0) + 1);
      result++;

      str = br.readLine();
      if (str == null || str.length() == 0) {
        break;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Entry<String, Integer> entry : map.entrySet()) {
      double percentage = (entry.getValue() / result) * 100.0;
      sb.append(entry.getKey() + " " + String.format("%.4f", percentage) + "\n");
    }
    System.out.println(sb);
  }
}