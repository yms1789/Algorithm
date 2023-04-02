import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;
		if (i == 0) {
			System.out.println(-1);
			return;
		}
		int j = N - 1;
		while (arr[i - 1] >= arr[j])
			--j;
		swap(arr, i - 1, j);
		int k = N - 1;
		while (i < k)
			swap(arr, i++, k--);
		for (int idx = 0; idx < N; idx++) {
			System.out.print(arr[idx] + " ");
		}

	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}