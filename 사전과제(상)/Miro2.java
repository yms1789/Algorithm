import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Miro2 {
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
		for (int tc = 1; tc <= 10; tc++) {
			int testCase = Integer.parseInt(br.readLine());
			int N = 100;
			int[][] map = new int[N][N];
			// 아래, 오른쪽, 왼쪽, 위
			int[] dx = { 1, 0, 0, -1 };
			int[] dy = { 0, 1, -1, 0 };
			int flag = 0;

			Queue<Dir> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
					visited[i][j] = map[i][j] == 1 ? true : false;
				}
			}
			int startX = 1;
			int startY = 1;
			queue.offer(new Dir(startX, startY));
			while(!queue.isEmpty()) {
				Dir cur = queue.poll();
				int curX = cur.x;
				int curY = cur.y;
				if(map[curX][curY] == 3) {
					flag = 1;
					break;
				}
				for(int j = 0; j < dx.length; j++) {
					int nx = curX + dx[j];
					int ny = curY + dy[j];
					if (0 > nx || nx >= N || 0 > ny || ny >= N)
						continue;
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Dir(nx, ny));
						
					}
				}
			}
			System.out.println("#" + testCase + " " + flag);
		}

	}
}
