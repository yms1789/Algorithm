import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2105 {
	static int N;
	static int[][] cafe;


	static int maxNum = 0;
//	static int[] dx = { -1, -1, 1, 1 };
//	static int[] dy = { -1, 1, 1, -1 };
	// 11시, 1시, 5시, 7시 -> 이렇게 하면 11시 방향이 날아가버림, 첫번째 방향은 무조건 이동가능한 방향으로 움직여야 함
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	// 5시, 7시, 11시, 1시 
	static int startx, starty;
	static boolean[][] visited;
	static boolean [] tour;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			maxNum = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// dfs로 한 정점에서 부터 대각선으로 쭉 이동
			// 계속 이동하면서 원래 정점에 도달했을 때 방문했던 카페들이 안겹친다면
			// max이랑 비교해서 더 큰 값을 max에 넣음
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					visited = new boolean[N][N];
					tour = new boolean[101];
					tour[cafe[i][j]] = true;
					visited[i][j] = true;
					dfs(i, j, 1, i, j, 0);
				}
			}
			if(maxNum == 0) System.out.println("#" + tc + " " + -1);
			else System.out.println("#" + tc + " " + maxNum);
		}
	}

	static void dfs(int cx, int cy, int count, int ix, int iy, int prevDir) {
		// 다시 처음으로 돌아온 걸 어떻게 판단?
		for (int i = prevDir; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(nx == ix && ny == iy && count > 2) {
					maxNum = Math.max(count, maxNum);
					return;
				}
				if(!visited[nx][ny] && !tour[cafe[nx][ny]]) {
					visited[nx][ny] = true;
					tour[cafe[nx][ny]] = true;
					dfs(nx, ny, count + 1, ix, iy, i);
					visited[nx][ny] = false;
					tour[cafe[nx][ny]] = false;
				}
			}
		}
	}
}
