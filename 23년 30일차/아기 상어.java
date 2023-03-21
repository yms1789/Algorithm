import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Dir {
		int x;
		int y;

		public Dir(int dx, int dy) {
			// TODO Auto-generated constructor stub
			this.x = dx;
			this.y = dy;
		}
	}

	static int N;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int[][] space;
	static Queue<Dir> queue;
	static int baby = 2;
	static int eat = 0;
	static int count = 0;
	static int[][] range;
	static int minX, minY, minR;
	static Dir start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] == 9) {
					start = new Dir(i, j);
					space[i][j] = 0;
				}
			}
		}
		while (true) {
			queue = new LinkedList<>();
			queue.add(start);
			range = new int[N][N];

			minX = Integer.MAX_VALUE;
			minY = Integer.MAX_VALUE;
			minR = Integer.MAX_VALUE;

			bfs();

			if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				eat++;
				space[minX][minY] = 0;
				start = new Dir(minX, minY);
				count += range[minX][minY];

				if (eat == baby) {
					eat = 0;
					baby++;
				}
			} else { // 더 이상 먹을 물고기 X
				break;
			}

		}
		System.out.println(count);
	}

	static void bfs() {

		while (!queue.isEmpty()) {
			Dir cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || range[nx][ny] != 0 || space[nx][ny] > baby) {
					continue;
				}

				range[nx][ny] = range[cur.x][cur.y] + 1;

				if (space[nx][ny] < baby && space[nx][ny] != 0) { // 먹을 수 있을 때
					if (minR > range[nx][ny]) { // 새로운 칸이 최소 거리라면
						minR = range[nx][ny];
						minX = nx;
						minY = ny;
					} else if (minR == range[nx][ny]) { // 거리가 같다면
						if (minX == nx) {
							if (minY > ny) {
								minY = ny;
							}
						} else if (minX > nx) {
							minX = nx;
							minY = ny;
						}
					}
				}
				queue.add(new Dir(nx, ny));
			}
		}
	}
}