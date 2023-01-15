import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rsp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if (a == 1) {
			if (b == 2)
				System.out.println("B");
			else
				System.out.println("A");
		}
		if (a == 2) {
			if (b == 3)
				System.out.println("B");
			else
				System.out.println("A");

		}
		if (a == 3) {
			if (b == 1)
				System.out.println("B");
			else
				System.out.println("A");
		}

	}
}
