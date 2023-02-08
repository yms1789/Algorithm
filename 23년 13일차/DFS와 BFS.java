import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		int [][] arr = new int[N + 1][N + 1];
		boolean [] visited = new boolean[N + 1];
		visited[0] = true;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		dfs(arr, visited, V);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(arr, visited, V);
		
	}
	public static void dfs(int [][] arr, boolean [] visited, int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for(int i = 0; i <= N; i++) {
			if(!visited[i] && arr[start][i] == 1) {
				dfs(arr, visited, i);
			}
		}
	}
	public static void bfs(int [][] arr, boolean [] visited, int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			for(int i = 0; i <= N; i++) {
				if(!visited[i] && arr[cur][i] == 1) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
}
