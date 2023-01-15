import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Miro1 {
	static class Dir {
		int x;
		int y;

		Dir(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int tc = Integer.parseInt(br.readLine());
			final int N = 16;
			int[][] map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			Queue<Dir> queue = new LinkedList<>();
			int flag = 0;
			// 아래, 오른쪽, 왼쪽, 위
			int[] dx = { 1, 0, 0, -1 };
			int[] dy = { 0, 1, -1, 0 };
			
			for (int j = 0; j < N; j++) {
				String[] line = br.readLine().split("");
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(line[k]);
					visited[j][k] = map[j][k] == 1 ? true : false;
				}
			}
			int startX = 1;
			int startY = 1;
			queue.offer(new Dir(startX, startY));
			while (!queue.isEmpty()) {
				Dir cur = queue.poll();
				int curX = cur.x;
				int curY = cur.y;

				if (map[curX][curY] == 3) {
					flag = 1;
					break;
				}
				for (int j = 0; j < 4; j++) {
					int nx = curX + dx[j];
					int ny = curY + dy[j];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Dir(nx, ny));
					}
				}
			}
			System.out.println("#" + tc + " " + flag);
		}
	}
}
