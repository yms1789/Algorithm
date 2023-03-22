import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class Node {
		int parent, lchild, rchild;

		Node() {
			this.parent = 0;
			this.lchild = 0;
			this.rchild = 0;
		}
	}

	static int N;
	static int V, E, v1, v2;
	static Node[] tree;
	static int commonParent = 1;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());

			tree = new Node[V + 1];
			visited = new boolean[V + 1];
			count = 0;
			for (int i = 1; i <= V; i++) {
				tree[i] = new Node();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				if (tree[parent].lchild == 0)
					tree[parent].lchild = child;
				else
					tree[parent].rchild = child;
				tree[child].parent = parent;
			}

			findMinCommon();

			System.out.println("#" + tc + " " + commonParent + " " + count);
		}
	}

	static void findMinCommon() {
		while (true) {
			// 각 정점들이 루트 노드가 아니라면 해당 정점의 한 단계 상위로 이동해서 방문처리
			// -> 두 정점이 공통 노드를 만날 때 까지 반복(상위 노드가 이미 방문한 상태면 공통 노드!)
			if (v1 != 1) {
				int parent = tree[v1].parent;
				if (visited[parent]) {
					commonParent = parent;
					break;
				}
				visited[parent] = true;
				v1 = parent;
			}
			if (v2 != 1) {
				int parent = tree[v2].parent;
				if (visited[parent]) {
					commonParent = parent;
					break;
				}
				visited[parent] = true;
				v2 = parent;
			}
		}
		countSub(tree[commonParent]);

	}

	static void countSub(Node node) {
		// 재귀로 노드의 좌, 우측 자식이 모두 없을 때(리프 노드)까지 반복하면서 count 증가
		count++;
		if (node.lchild != 0)
			countSub(tree[node.lchild]);
		if (node.rchild != 0)
			countSub(tree[node.rchild]);
	}
}