import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long M;
	static long[] trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		trees = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);

		long start = 0;
		long end = trees[trees.length - 1];
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for (long tree : trees) {
				if (tree > mid) {
					sum += tree - mid;
				}
			}
			if (sum < M) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(end);
	}
}