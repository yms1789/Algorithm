import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] selectedIceCream = new int[3];
	static boolean[][] map;
	static int result = 0;

	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = true;
			map[y][x] = true;
		}

		combination(0, 1);
		System.out.println(result);
	}

	static void combination(int depth, int idx) {

		if (depth == 3) {
			if (notMix()) {
				result++;
			}
			return;
		}
		for (int i = idx; i < N + 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selectedIceCream[depth] = i;
				combination(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	static boolean notMix() {
		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (map[selectedIceCream[i]][selectedIceCream[j]])
					return false;
			}
		}
		return true;
	}
}
