import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F, S, G, U, D;
	static Queue<Integer> queue;
	static int[] dx = { 1, -1 }; // U D
	static int[] floors;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken()); // 건물 전체 층 수
		S = Integer.parseInt(st.nextToken()); // 현재 위치
		G = Integer.parseInt(st.nextToken()); // 도착할 층
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		queue = new LinkedList<>();

		queue.add(S);
		floors = new int[F + 1];
		floors[S] = 1;
		bfs();
		if (S == G) {
			System.out.println(0);
		} else {
			if (floors[G] == 0) {
				System.out.println("use the stairs");
			} else {
				System.out.println(floors[G] - 1);
			}
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int curx = queue.poll();
			if (curx == G) {
				break;
			}
			for (int i = 0; i < 2; i++) {
				int nx;
				if (i == 0) {
					nx = curx + (dx[i] * U);
				} else {
					nx = curx + (dx[i] * D);
				}
				if (nx < 1 || nx > F || floors[nx] != 0) {
					continue;
				}
				queue.add(nx);
				floors[nx] = floors[curx] + 1;

			}
		}
	}
}