import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

class Pair {
	int left, right;

	public Pair(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

public class Main {
	static List<Pair> pairs;
	static int pairCount;
	static TreeSet<String> treeSet;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		Stack<Integer> stack = new Stack<>();
		treeSet = new TreeSet<>();
		pairs = new ArrayList<>();
		int inputSize = exp.length();
		for (int i = 0; i < inputSize; i++) {
			char curr = exp.charAt(i);
			if(curr == '(') {
				stack.add(i);
			} else if(curr == ')') {
				pairs.add(new Pair(stack.pop(), i));
			}
		}
		pairCount = pairs.size();
		makeString(0, exp);
		StringBuilder res = new StringBuilder();
		for(String bracket : treeSet) {
			if(bracket.equals(exp)) {
				continue;
			}
			res.append(bracket).append("\n");
		}
		System.out.println(res);
	}
	static void makeString(int idx, String str) {
		if(idx == pairCount) {
			treeSet.add(str.replaceAll(" ", ""));
			return;
		}
		Pair pair = pairs.get(idx);
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(pair.left, ' ');
		sb.setCharAt(pair.right, ' ');
		makeString(idx + 1, sb.toString());
		
		makeString(idx + 1, str);
	}
}