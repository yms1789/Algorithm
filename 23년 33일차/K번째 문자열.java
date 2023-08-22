import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	static Set<String> subSet;
	static String[] str;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// 문자열을 부분집합으로 쪼갬
		// 쪼갠 부분집합을 Set에 넣고
		// Set을 comparator를 이용해서 정렬
		// k번째 문자열 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int target = Integer.parseInt(br.readLine());
			str = br.readLine().split("");
			visited = new boolean[str.length];
			subSet = new TreeSet<>();

			for (int i = 0; i <= str.length; i++) {
				for (int j = i + 1; j <= str.length; j++) {
					String subStr = String.join("", str).substring(i, j);
//					System.out.println(subStr);
					subSet.add(subStr);
				}
			}

			int idx = 1;
			String res = "";
			for (String elem : subSet) {
				if (idx == target) {
					res = elem;
					break;
				}
				idx++;
			}
			if(res.length() <= 0) {
				System.out.println("#" + tc + " " + "none");
			} else {
				System.out.println("#" + tc + " " + res);
			}
		}
	}
}
