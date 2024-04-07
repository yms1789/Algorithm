const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

// 특정 노드를 dfs를 수행하는 과정에서 인접노드가 이미 방문한 노드라면 사이클!(단 무방향 그래프이므로 직전 노드는 제외!)
let tc = 1;
for (let T = 0; ; ) {
  if (input[T][0] === 0) break;
  let [N, M] = input[T];
  let tree = Array.from({ length: N + 1 }, () => []);
  for (let i = T + 1; i <= T + M; i++) {
    let [start, end] = input[i];
    tree[start].push(end);
    tree[end].push(start);
  }
  let count = 0;
  let visited = Array(N + 1).fill(false);

  for (let i = 1; i <= N; i++) {
    if (!visited[i] && !isCycle(i, 0, visited, tree)) {
      count++;
    }
  }
  logging(count, tc);
  T += M + 1;
  tc++;
}

function isCycle(cur, prev, visited, tree) {
  visited[cur] = true; // 현재 노드 방문처리
  for (let i = 0; i < tree[cur].length; i++) {
    // 인접노드를 하나씩 확인
    let next = tree[cur][i];
    if (!visited[next]) {
      // 다음 노드를 방문하지 않았다면 다음 노드 기준으로 사이클인지 확인
      if (isCycle(next, cur, visited, tree)) return true;
    } else if (next !== prev) return true; // 방문한 적 있는데 직전 노드가 아니라면 사이클
  }
  return false;
}

function logging(count, T) {
  if (count === 0) {
    console.log(`Case ${T}: No trees.`);
  }
  if (count === 1) {
    console.log(`Case ${T}: There is one tree.`);
  }
  if (count > 1) {
    console.log(`Case ${T}: A forest of ${count} trees.`);
  }
}
