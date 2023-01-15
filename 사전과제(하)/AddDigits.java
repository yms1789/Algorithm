import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class AddDigits {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String num = st.nextToken();
		String [] arr = num.split("");
		int sum = 0;
		for(int i : Stream.of(arr).mapToInt(Integer::parseInt).toArray()) {
			sum += i;
		}
		System.out.println(sum);
	}
}
