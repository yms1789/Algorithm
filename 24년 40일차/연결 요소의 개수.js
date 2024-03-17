const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, M] = input[0];

let map = Array.from({ length: N + 1 }, () => []);
let visited = Array(N + 1).fill(false);
for (let i = 1; i < input.length; i++) {
  map[input[i][0]].push(input[i][1]);
  map[input[i][1]].push(input[i][0]);
}

let count = 0;

function bfs(cur) {
  let queue = [cur];
  visited[cur] = true;
  while (queue.length) {
    let curNode = queue.shift();
    for (let i = 0; i < map[curNode].length; i++) {
      let nextNode = map[curNode][i];
      if (!visited[nextNode]) {
        queue.push(nextNode);
        visited[nextNode] = true;
      }
    }
  }
  count++;
}

for (let i = 1; i <= N; i++) {
  if (!visited[i]) {
    bfs(i);
  }
}

console.log(count);
