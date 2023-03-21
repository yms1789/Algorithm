import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static int[][] world;
	static int[] wall;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		world = new int[H][W];
		wall = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			wall[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < wall[i]; j++) {
				world[H - 1 - j][i] = 1;
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (world[i][j] == 0) {
					if (isWall(i, j)) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	static boolean isWall(int row, int startCol) {
		int count = 0;
		for (int i = startCol; i < W; i++) {
			if (world[row][i] == 1) {
				count++;
				break;
			}
		}
		for (int i = startCol; i >= 0; i--) {
			if (world[row][i] == 1) {
				count++;
				break;
			}
		}
		return count == 2 ? true : false;
	}
}