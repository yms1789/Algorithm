import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Dir {
	int x;
	int y;

	Dir(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Supply {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			Queue<Dir> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			// 아래, 오른쪽, 왼쪽, 위
			int[] dx = { 1, 0, 0, -1 };
			int[] dy = { 0, 1, -1, 0 };
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
					visited[i][j] = false;
				}
			}
			int[][] res = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(res[i], Integer.MAX_VALUE);
			}

			int startX = 0;
			int startY = 0;
			res[startX][startY] = 0;

			int depth = Integer.MAX_VALUE;
			queue.offer(new Dir(startX, startY));
			while (!queue.isEmpty()) {
				Dir cur = queue.poll();
				int curX = cur.x;
				int curY = cur.y;
				if (curX == N - 1 && curY == N - 1) {
					depth = depth > res[N - 1][N - 1] ? res[N - 1][N - 1] : depth;
				}
				if(depth <= res[curX][curY])
					continue;
				
				for (int j = 0; j < dx.length; j++) {
					int nx = curX + dx[j];
					int ny = curY + dy[j];
					if (0 > nx || nx >= N || 0 > ny || ny >= N)
						continue;
					if (!visited[nx][ny] || res[nx][ny] > res[curX][curY] + map[nx][ny]) {
						visited[nx][ny] = true;
						res[nx][ny] = res[curX][curY] + map[nx][ny];
						queue.offer(new Dir(nx, ny));
					}
				}
			}
			System.out.println("#" + test_case + " " + depth);
		}
	}
}