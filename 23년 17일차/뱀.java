import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int L;
	static String trans;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 }; // 동, 북, 서, 남

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		int[][] board = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			String[] appleDir = br.readLine().split(" ");
			board[Integer.parseInt(appleDir[0])][Integer.parseInt(appleDir[1])] = 1;
		}
		board[1][1] = 2;
		L = Integer.parseInt(br.readLine());
		Map<Integer, String> snakeTransInfo = new HashMap<>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			snakeTransInfo.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		// 뱀 이동
		Deque<int[]> snakeMoveQueue = new ArrayDeque<>();
		int cx = 1;
		int cy = 1;
		int[] curDir = { cx, cy };
		snakeMoveQueue.offer(curDir);
		
		int count = 0;
		int d = 0;
		boolean flag = true;
		while (flag) {
			count++;
			String moveInfo = "R";
			int [] nextDir = {(curDir[0] + dx[d]), (curDir[1] + dy[d])};
			// 이전 거에서 D 면 오른쪽 90도, L이면 왼쪽 90도
			if ((trans = snakeTransInfo.get(count)) != null) {
				moveInfo = trans;
			}
			if (moveInfo.equals("D")) {
				d += 1;
				if (d == 4)
					d = 0;
			}
			if (moveInfo.equals("L")) {
				d -= 1;
				if (d == -1)
					d = 3;
			}
			if (nextDir[0] <= 0 || nextDir[0] >= (N + 1) || nextDir[1] <= 0 || nextDir[1] >= (N + 1)) {
				break;
			}
			for (int[] snake : snakeMoveQueue) {
				if (snake[0] == nextDir[0] && snake[1] == nextDir[1]) {
					flag = false;
				}
			}
			if (board[nextDir[0]][nextDir[1]] == 1) {
				board[nextDir[0]][nextDir[1]] = 0;
				snakeMoveQueue.offerFirst(nextDir);
			} else {
				snakeMoveQueue.offerFirst(nextDir);
				snakeMoveQueue.pollLast();
			}
			curDir = nextDir;
		}
		System.out.println(count);
	}
}
