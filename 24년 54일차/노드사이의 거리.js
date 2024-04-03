const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));
const [N, M] = input[0];

let nodes = Array.from({ length: N + 1 }, () => []);

for (let i = 1; i < N; i++) {
  let [a, b, len] = input[i];
  nodes[a].push([b, len]);
  nodes[b].push([a, len]);
}
// nodes[0] = [[인접 노드, 거리]]
let select = input.slice(N, N + M);

let result = Array(select.length).fill(Number.MAX_VALUE);

function dfs(sel, start, end, count, visited) {
  if (start === end) {
    result[sel] = Math.min(result[sel], count);
    return;
  }
  for (let i = 0; i < nodes[start].length; i++) {
    if (!visited[nodes[start][i][0]]) {
      count += nodes[start][i][1];
      visited[nodes[start][i][0]] = true;
      dfs(sel, nodes[start][i][0], end, count, visited);
      count -= nodes[start][i][1];
      visited[nodes[start][i][0]] = false;
    }
  }
}

for (let i = 0; i < select.length; i++) {
  let count = 0;
  let visited = Array(N + 1).fill(false);
  visited[select[i][0]] = true;
  dfs(i, select[i][0], select[i][1], count, visited);
}

console.log(result.join("\n"));
