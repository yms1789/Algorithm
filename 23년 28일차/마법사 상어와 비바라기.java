import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Cloud {
		int x;
		int y;

		public Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] move;
	static Queue<Cloud> clouds = new LinkedList<>();
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	// 좌, 좌상, 상, 우상, 우, 우하, 하, 좌하
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		move = new int[M][2];
		visited = new boolean[N][N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				move[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구름 생성
		clouds.add(new Cloud(N - 1, 0));
		clouds.add(new Cloud(N - 1, 1));
		clouds.add(new Cloud(N - 2, 0));
		clouds.add(new Cloud(N - 2, 1));

		for (int i = 0; i < M; i++) {
			step12(move[i][0] - 1, move[i][1]);
			step34();
			step5();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}

	static void step12(int d, int s) {
		for (Cloud cloud : clouds) {
			cloud.x = (N + cloud.x + dx[d] * (s % N)) % N;
			cloud.y = (N + cloud.y + dy[d] * (s % N)) % N;
			map[cloud.x][cloud.y]++;
		}
	}

	static void step34() {
		while (!clouds.isEmpty()) {
			Cloud cloud = clouds.poll();
			int cnt = 0;

			visited[cloud.x][cloud.y] = true;
			for (int i = 1; i < 8; i += 2) {
				int nx = cloud.x + dx[i];
				int ny = cloud.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (map[nx][ny] >= 1)
						cnt++;
				}
			}
			map[cloud.x][cloud.y] += cnt;

		}
	}

	static void step5() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] >= 2) {
					map[i][j] -= 2;
					clouds.add(new Cloud(i, j));
				}
			}
		}
		visited = new boolean[N][N];
	}
}