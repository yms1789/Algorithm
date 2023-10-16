const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();
let [N, M, ...input] = stdin.split("\n");
N = Number(N);
M = Number(M);
input = input.map((ele) => ele.split(" ").map(Number));

let graph = Array.from({ length: N + 1 }, () => []);
for (let i = 0; i < input.length; i++) {
  graph[input[i][0]].push(input[i][1]);
  graph[input[i][1]].push(input[i][0]);
}
let visited = Array(N + 1).fill(false);
let queue = [1];
while (queue.length) {
  let cur = queue.shift();
  for (let i = 0; i < graph[cur].length; i++) {
    if (!visited[graph[cur][i]]) {
      queue.push(graph[cur][i]);
      visited[graph[cur][i]] = true;
    }
  }
}
console.log(
  visited.filter((ele) => !!ele).length - 1 <= 0
    ? 0
    : visited.filter((ele) => !!ele).length - 1
);
