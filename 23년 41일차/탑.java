import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Stack<Integer> arr;
	static Stack<Integer> idx;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new Stack<>();
		idx = new Stack<>();
		max = Integer.MIN_VALUE;
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			while(!arr.isEmpty()) {
				if(cur < arr.peek()) {
					sb.append(idx.peek() + " ");
					break;
				}
				arr.pop();
				idx.pop();
			}
			if (arr.isEmpty()) {
				sb.append("0 ");
			}
			arr.add(cur);
			idx.add(i + 1);
		}
		
		
		System.out.println(sb.toString());
	}
}