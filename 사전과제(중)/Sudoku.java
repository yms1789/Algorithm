import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int test = 1; test <= tc; test++) {
			String[][] numArr = new String[9][9];
			boolean flag = true;
			for (int i = 0; i < numArr.length; i++) {
				numArr[i] = br.readLine().split(" ");
			}
			// 가로
			for (int i = 0; i < numArr.length; i++) {
				Set<String> numSet = new HashSet<>();
				for (int j = 0; j < numArr[i].length; j++) {
					numSet.add(numArr[i][j]);
				}
				if (numSet.size() != numArr[i].length) {
					flag = false;
				}
			}
			// 세로
			for (int i = 0; i < numArr.length; i++) {
				Set<String> numSet = new HashSet<>();
				for (int j = 0; j < numArr[i].length; j++) {
					numSet.add(numArr[j][i]);
				}
				if (numSet.size() != numArr[i].length) {
					flag = false;
				}
			}
			// 격자
			for (int t = 0; t < numArr.length; t += 3) {
				for (int k = 0; k < numArr.length; k += 3) {
					Set<String> numSet = new HashSet<>();
					for (int i = t; i < t + 3; i++) {
						for (int j = k; j < k + 3; j++) {
							numSet.add(numArr[i][j]);
							System.out.printf("%s %s\n", i, j);
						}
					}
					if (numSet.size() != numArr.length) {
						flag = false;
					}
				}
			}
			if (flag) {
				System.out.println("#" + test + " " + "1");
			} else {
				System.out.println("#" + test + " " + "0");
			}
		}
	}

}
