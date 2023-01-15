import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TwoNumArray {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			String[] num = br.readLine().split(" ");
			int N = Integer.parseInt(num[0]);
			int M = Integer.parseInt(num[1]);
			String[] numArr1 = br.readLine().split(" ");
			String[] numArr2 = br.readLine().split(" ");
			int move = Math.abs(N - M);
			int maxNum = 0;
			if (M > N) {
				for (int j = 0; j <= move; j++) {
					int temp = 0;
					for (int k = 0; k < N; k++) {
						temp += Integer.parseInt(numArr1[k]) * Integer.parseInt(numArr2[k + j]);
					}
					if (temp >= maxNum)
						maxNum = temp;
				}
			} else if (M < N) {
				for (int j = 0; j <= move; j++) {
					int temp = 0;
					for (int k = 0; k < M; k++) {
						temp += Integer.parseInt(numArr2[k]) * Integer.parseInt(numArr1[k + j]);
					}
					if (temp >= maxNum)
						maxNum = temp;
				}
			} else {
				int temp = 0;
				for (int k = 0; k < N; k++) {
					temp += Integer.parseInt(numArr2[k]) * Integer.parseInt(numArr1[k]);
				}
				if (temp >= maxNum)
					maxNum = temp;
			}
			System.out.println("#" + i + " " + maxNum);
		}
	}
}