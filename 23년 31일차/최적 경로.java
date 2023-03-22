import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class Dir {
		int x;
		int y;

		Dir(int dx, int dy) {
			this.x = dx;
			this.y = dy;
		}
	}

	static int N;
	static boolean[] visited;
	static int minRange;
	static Dir[] customers;
	static Dir office, home;
	static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			visited = new boolean[N];
			order = new int[N];
			customers = new Dir[N];

			for (int i = 0; i < N + 2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (i == 0) { // 회사
					office = new Dir(x, y);
				} else if (i == 1) { // 집
					home = new Dir(x, y);
				} else {
					customers[i - 2] = new Dir(x, y);
				}
			}
			minRange = Integer.MAX_VALUE;
			dfs(0, 0);

			System.out.println("#" + tc + " " + minRange);
		}

	}

	static void dfs(int x, int depth) {
		if (depth == N) {
			goHome();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[x] = i;
				dfs(x + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	static void goHome() {
		int sum = 0;
		// 회사 -> 첫번째 고객까지
		sum += Math.abs(office.x - customers[order[0]].x) + Math.abs(office.y - customers[order[0]].y);

		// 첫번째 고객부터 N번째 고객 까지 거리
		for (int i = 1; i < N; i++) {
			sum += Math.abs(customers[order[i - 1]].x - customers[order[i]].x)
					+ Math.abs(customers[order[i - 1]].y - customers[order[i]].y);
		}
		// N번째 고객 -> 집까지
		sum += Math.abs(home.x - customers[order[N - 1]].x) + Math.abs(home.y - customers[order[N - 1]].y);

		minRange = Math.min(minRange, sum);
	}

}