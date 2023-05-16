import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Dir> queue;
	static int maxHouse;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			maxHouse = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					queue = new LinkedList<>();
					bfs(i, j);
				}
			}
			System.out.println("#" + tc + " " + maxHouse);
		}

	}

	static void bfs(int x, int y) {
		int K = 1;
		int house = map[x][y];
		visited[x][y] = true;
		queue.offer(new Dir(x, y));
		
		while (!queue.isEmpty()) {
			K++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Dir cur = queue.poll();
				int cx = cur.x;
				int cy = cur.y;
				for (int j = 0; j < 4; j++) { // 아래, 위, 오른쪽, 왼쪽
					int nx = cx + dx[j];
					int ny = cy + dy[j];
					if (isWall(nx, ny) || visited[nx][ny]) {
						continue;
					}
					queue.add(new Dir(nx, ny));
					visited[nx][ny] = true;
					if (map[nx][ny] == 1)
						house++;

				}
			}
			if (calcCost(K) <= M * house)
				maxHouse = Math.max(maxHouse, house);
		}
	}

	static boolean isWall(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return true;
		}
		return false;
	}

	static int calcCost(int k) {
		return (k * k) + (k - 1) * (k - 1);
	}

	static void printVisited() {
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j] + " ");
			}
		}
		System.out.println();

	}
}