import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B;
	static int[] clerk;
	static int res;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken()); // 높이
			clerk = new int[N];
			visited = new boolean[N];
			res = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				clerk[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= N; i++) {
				combi(0, 0, i);
			}
			System.out.println("#" + tc + " " + Math.abs(res - B));
		}
	}

	// 점원들 조합해서 가장 B보다 큰 가장 작은 탑을 만들려고 함
	// 재귀 돌릴 때 combi(idx + 1, )로 하면 어떡하니... => 이거때문에 시간초과 나고 있었음
	static void combi(int idx, int depth, int R) {
		if (depth == R) {
			int sum = 0;
			for(int i = 0; i < N ; i++) {
				if(visited[i]) {
					sum += clerk[i];
				}
			}
			if (sum < B) {
				return;
			}
			int diff = Math.abs(sum - B); // 현재 값이랑 B와의 차
			res = diff <= Math.abs(res - B) ? sum : res;
			return;
		}
		for (int i = idx; i < N; i++) {
			visited[i] = true;
			combi(i + 1, depth + 1, R);
			visited[i] = false;
		}
	}
}
