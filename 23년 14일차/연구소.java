import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
	int x;
	int y;

	public Virus(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N;
	static int M;
	static LinkedList<Virus> virusDir;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		virusDir = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virusDir.add(new Virus(i, j));
			}
		}
		dfs(0, map);
		System.out.println(result);
	}

	public static void dfs(int wall, int[][] map) {
		if (wall == 3) {
			bfs(map);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wall + 1, map);
					map[i][j] = 0;
				}
			}
		}

	}

	public static void bfs(int[][] map) {
		int[][] infected = new int[N][M];
		Queue<Virus> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				infected[i][j] = map[i][j];
			}
			
		}
		for(Virus i : virusDir) {
			queue.add(i);
		}
		while (!queue.isEmpty()) {
			Virus curVirus = queue.poll();
			int curx = curVirus.x;
			int cury = curVirus.y;
			for (int i = 0; i < 4; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (infected[nx][ny] == 0) {
						queue.add(new Virus(nx, ny));
						infected[nx][ny] = 2;
					}
				}
			}
		}
		countSafeZone(infected);
	}

	public static void countSafeZone(int[][] infected) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (infected[i][j] == 0)
					count++;
			}
		}
		result = Math.max(result, count);
	}
}
