const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [T] = input[0];

// 한 팀에 포함된 임의의 학생 A, B가 있을 때 A에서 B로 도달할 수 있어야 함
// 즉, 사이클을 구성하는 부분 그래프에 포함된 노드의 개수를 세는 문제!
let result = 0;

for (let i = 0; i < input.length - 1; ) {
  let [N] = input[i + 1];
  let numbers = [0, ...input[i + 2]];
  i += 2;

  let visited = Array(N + 1).fill(false);
  let finished = Array(N + 1).fill(false);

  for (let j = 1; j <= N; j++) {
    if (!visited[j]) dfs(j, numbers, visited, finished);
  }

  console.log(N - result);
  result = 0;
}
function dfs(cur, numbers, visited, finished) {
  visited[cur] = true;
  let next = numbers[cur];
  if (!visited[next]) {
    // 다음 노드가 방문조차 안 한 노드라면
    dfs(next, numbers, visited, finished);
  } else if (!finished[next]) {
    // 다음 노드가 방문 처리는 되어있는데 아직 마무리가 안된 노드라면(스택에서 안빠져 나감)
    while (next !== cur) {
      result++;
      next = numbers[next];
    }
    result++;
  }
  finished[cur] = true;
}
