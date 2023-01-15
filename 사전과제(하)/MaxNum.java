import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

class MaxNum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int[] numArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(numArr);
			System.out.println("#" + (i + 1) + " " + numArr[numArr.length - 1]);

		}

	}
}
