import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea2382 {
	static int N, M, K;

	static class Position {
		int x;
		int y;

		Position(int dx, int dy) {
			this.x = dx;
			this.y = dy;
		}
	}

	static class Group {
		int x;
		int y;
		int micro;
		int dir;

		Group(int dx, int dy, int count, int dir) {
			this.x = dx;
			this.y = dy;
			this.micro = count;
			this.dir = dir;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	// 상(0), 하(1), 좌(2), 우(3)
	static Group[] map;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new Group[K];
			ans = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int mCount = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[i] = new Group(row, col, mCount, dir);
			}
			// 세로위치(1), 가로위치(1), 미생물 수(7), 이동방향(상)

			for (int i = 1; i <= M; i++) {
				move();
//				findSameCell();
				// 같은 행, 열에 있는 미생물 군집을 찾는 것도 방법이지만 그렇게 하면 복잡도가 너무 커짐
		
				// 미생물 군집을 내림차순 정렬(행 -> 열 -> 미생물 수 순으로)
//				Collections.sort(microList);
//				 
				// i번째 미생물 군집과 i + 1번째 미생물 군집의 row, col을 비교해서 같으면 i번째 미생물 수 += i + 1번째 미생물 수
				// -> i + 1번째 군집 제거, i -= 1 => 이렇게 하면 행, 열 비교를 굳이 하지 않고도 모든 미생물 군집에 대해 행, 열 비교가 가능! 
//		        for (int i = 0; i < microList.size() - 1; i++) {
//		            Micro m = microList.get(i);
//		            Micro nextM = microList.get(i + 1);
//		            if (m.r == nextM.r && m.c == nextM.c) {
//		                m.cnt += nextM.cnt;
//		                microList.remove(i + 1);
//		                i = i - 1;
//		            }
//		        }
			}
			ans = solve();
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int solve() {
		int sum = 0;
		for (int i = 0; i < K; i++) {
			if (map[i] != null)
				sum += map[i].micro;
		}
		return sum;
	}

	static void move() {
		for (int i = 0; i < K; i++) {
			if (map[i] != null) {
				int nx = map[i].x + dx[map[i].dir];
				int ny = map[i].y + dy[map[i].dir];
				// 테두리에 있을 때
				if (isBorder(nx, ny)) {
					// 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값
					map[i].micro = (int) Math.floor(map[i].micro / 2);
					if (map[i].dir == 0) {
						map[i].dir = 1;
					} else if (map[i].dir == 1) {
						map[i].dir = 0;
					} else if (map[i].dir == 2) {
						map[i].dir = 3;
					} else if (map[i].dir == 3) {
						map[i].dir = 2;
					}
				}
				if (map[i].micro == 0) {
					map[i] = null;
				} else {
					map[i].x = nx;
					map[i].y = ny;
				}
			}
		}
	}

	static void findSameCell() {
		List<Group> sameCell;
		List<Position> cellPosition = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			if (map[i] != null)
				cellPosition.add(new Position(map[i].x, map[i].y));
		}
		for (int i = 0; i < cellPosition.size(); i++) {
			sameCell = new ArrayList<>();
			for (int j = 0; j < K; j++) {
				if (map[j] != null && cellPosition.get(i).x == map[j].x && cellPosition.get(i).y == map[j].y) {
					sameCell.add(map[j]);
				}
			}
			if (sameCell.size() >= 2)
				combine(sameCell);
		}
	}

	static void combine(List<Group> sameCell) {
		Group maxMicro = sameCell.get(0);
		int sum = sameCell.get(0).micro;
		for (int i = 1; i < sameCell.size(); i++) {
			if (maxMicro.micro < sameCell.get(i).micro) {
				maxMicro = sameCell.get(i);
			}
			sum += sameCell.get(i).micro;
		}
		boolean flag = false;
		for (int i = 0; i < K; i++) {
			if (map[i] != null) {
				if (map[i].x == maxMicro.x && map[i].y == maxMicro.y) {
					if (!flag) {
						map[i].micro = sum;
						map[i].dir = maxMicro.dir;
						flag = true;
					} else {
						map[i] = null;
					}
				}
			}
		}
	}

	static boolean isBorder(int x, int y) {
		if (x <= 0 || x >= N - 1 || y <= 0 || y >= N - 1) {
			return true;
		}
		return false;
	}
}