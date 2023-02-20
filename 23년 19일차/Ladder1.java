import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int LENGHT = 100;
	static int[] dy = { -1, 1 }; // 왼쪽, 오른쪽

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
		int test = Integer.parseInt(br.readLine());
		int[][] ladder = new int[LENGHT][LENGHT];
		int startX = 0, startY = 0;
		for (int i = 0; i < LENGHT; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < LENGHT; j++) {
				ladder[i][j] = Integer.parseInt(st.nextToken());
				if (ladder[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		boolean[][] visited = new boolean[LENGHT][LENGHT];
		while (startX != 0) {
			visited[startX][startY] = true;
			if (startY - 1 >= 0 && ladder[startX][startY - 1] == 1 && visited[startX][startY - 1] == false) {
				startY--;
			} else if (startY + 1 < LENGHT && ladder[startX][startY + 1] == 1 && visited[startX][startY + 1] == false) {
				startY++;
			} else { // 아래로 이동
				startX--;
			}
		}
		System.out.println("#" + test + " " + startY);
		}
	}
}