import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Rotate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			int N = Integer.parseInt(br.readLine());
			String[][] numArr = new String[N][N];
			for (int j = 0; j < N; j++) {
				numArr[j] = br.readLine().split(" ");
			}
			String[][] printArr = new String[N][3];
			for (int j = 0; j < 3; j++) {
				String[][] rotateArr = new String[N][N];
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < N; l++) {
						switch (j) {
						case 0: // 90
							rotateArr[k][l] = numArr[N - 1 - l][k];
							break;
						case 1: // 180
							rotateArr[k][l] = numArr[N - 1 - k][N - 1 - l];
							break;
						case 2: // 270
							rotateArr[k][l] = numArr[l][N - 1 - k];
							break;
						default:
							break;
						}
					}
				}
				for (int x = 0; x < N; x++) {
					String text = "";
					for (int y = 0; y < N; y++) {
						text = text.concat(rotateArr[x][y]);
					}
					printArr[x][j] = text;
				}
			}
			System.out.printf("#%d\n", i);
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < 3; b++) {
					System.out.printf("%s ", printArr[a][b]);
				}
				System.out.println();
			}
		}
	}
}
