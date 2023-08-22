const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";

let [n, ...input] = fs.readFileSync(filePath).toString().trim().split("\n");

input = input.map((ele) => ele.split("").map(Number));
const [N, M] = n.split(" ");

let dx = [1, -1, 0, 0];
let dy = [0, 0, 1, -1];

let visited = Array.from({ length: N }, () => Array(M).fill(0));
function bfs(i, j) {
  let queue = [[i, j]];
  visited[0][0] = 1;
  while (queue.length) {
    const [cx, cy] = queue.shift();
    if (cx === N - 1 && cy === M - 1) {
      return;
    }
    for (let i = 0; i < 4; i++) {
      const [nx, ny] = [cx + dx[i], cy + dy[i]];
      if (
        nx < 0 ||
        ny < 0 ||
        nx >= N ||
        ny >= M ||
        visited[nx][ny] > 0 ||
        input[nx][ny] === 0
      )
        continue;
      visited[nx][ny] = visited[cx][cy] + 1;
      queue.push([nx, ny]);
    }
  }
}
bfs(0, 0);
console.log(visited[N - 1][M - 1]);
