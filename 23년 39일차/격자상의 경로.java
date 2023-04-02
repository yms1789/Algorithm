import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		map[0][1] = 1;
		int count = 0;

		int x = 0, y = 0;
		boolean flag = false;
		loop: for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				count += 1;
				map[i][j] = map[i - 1][j] + map[i][j - 1];
				if (count == K) {
					flag = true;
					x = i;
					y = j;
					break loop;
				}
			}
		}
		if (flag) {
			for (int i = x; i <= N; i++) {
				for (int j = y; j <= M; j++) {
					if (i - 1 >= x)
						map[i][j] += map[i - 1][j];
					if (j - 1 >= y)
						map[i][j] += map[i][j - 1];

				}
			}
		}
		System.out.println(map[N][M]);
	}
}