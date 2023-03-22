import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] box;
	static boolean[][] visited;
	static Queue<Dir> queue;
	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy = { 0, 1, -1, 0 };

	static class Dir {
		int x;
		int y;

		Dir(int dx, int dy) {
			this.x = dx;
			this.y = dy;
		}
	}

	// M은 가로, N은 세로
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		box = new int[N][M];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.add(new Dir(i, j));
					visited[i][j] = true;
				}
			}
		}

		if (tomatoState()) {
			System.out.println(0);
		} else {
			bfs();
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {

			Dir cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
					continue;
				}
				if (box[nx][ny] != -1) {
					box[nx][ny] = box[cur.x][cur.y] + 1;
					visited[nx][ny] = true;
					queue.add(new Dir(nx, ny));
				}
			}
		}
		if (!tomatoState()) {
			System.out.println(-1);
		} else {
			int day = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					day = Math.max(day, box[i][j]);
				}
			}
			System.out.println(day - 1);
		}
	}

	static boolean tomatoState() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}