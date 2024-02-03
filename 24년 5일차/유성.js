const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin
  .split("\n")
  .map((ele) => ele.split(" ").map((ele) => Number(ele)));

// 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도 없을 수도 있음

const N = input.shift()[0];
const M = input.shift()[0];

let graph = input.slice(0, M);

let route = input.at(-1);

let connected = Array.from({ length: M + 1 }, () => []);

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (graph[i][j]) {
      connected[i + 1].push(j + 1);
    }
  }
}
function bfs(cur, next, visited) {
  let queue = [cur];
  visited[cur] = true;
  while (queue.length) {
    for (let d = 0; d < queue.length; d++) {
      let node = queue[0];
      if (node === next) {
        return true;
      }
      for (let j = 0; j < connected[node].length; j++) {
        if (!visited[connected[node][j]]) {
          queue.push(connected[node][j]);
          visited[connected[node][j]] = true;
        }
      }
      queue.shift();
    }
  }
  return false;
}

for (let i = 0; i < M - 1; i++) {
  let visited = Array(N + 1).fill(false);
  if (!bfs(route[i], route[i + 1], visited)) {
    console.log("NO");
    break;
  }
  if (i === M - 2) {
    console.log("YES");
    break;
  }
}
