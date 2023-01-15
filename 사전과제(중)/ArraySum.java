import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraySum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int tc = Integer.parseInt(br.readLine());
			String[][] numArr = new String[100][100];
			int rowSum = 0;
			int colSum = 0;
			int rightSlash = 0;
			int leftSlash = 0;
			for (int j = 0; j < 100; j++) {
				numArr[j] = br.readLine().split(" ");
			}

			// 행 최대
			for (int j = 0; j < numArr.length; j++) {
				int temp = 0;
				for (int k = 0; k < numArr.length; k++) {
					temp += Integer.parseInt(numArr[j][k]);
				}
				if (rowSum <= temp) {
					rowSum = temp;
				}
			}
			// 열 최대
			for (int j = 0; j < numArr.length; j++) {
				int temp = 0;
				for (int k = 0; k < numArr.length; k++) {
					temp += Integer.parseInt(numArr[k][j]);
				}
				if (colSum <= temp) {
					colSum = temp;
				}
			}
			// 우측 대각선
			for (int j = 0, k = 0; k < numArr.length; j++, k++) {
				rightSlash += Integer.parseInt(numArr[j][k]);
			}
			// 좌측 대각선
			for (int j = 0, k = numArr.length - 1; k >= 0; j++, k--) {
				leftSlash += Integer.parseInt(numArr[j][k]);
			}
			int slashMax = Math.max(rightSlash, leftSlash);
			int rowColMax = Math.max(rowSum, colSum);

			System.out.println("#" + tc + " " + Math.max(slashMax, rowColMax));
		}

	}
}
