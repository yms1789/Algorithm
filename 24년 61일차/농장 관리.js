const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, M] = input[0];

const map = input.slice(1);

let dx = [-1, -1, 0, 1, 1, 1, 0, -1];
let dy = [0, 1, 1, 1, 0, -1, -1, -1];

let flag;
function bfs(x, y, height) {
  let queue = [[x, y]];
  while (queue.length) {
    let [cx, cy] = queue.shift();
    for (let d = 0; d < 8; d++) {
      let [nx, ny] = [cx + dx[d], cy + dy[d]];
      if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
      if (map[nx][ny] > height) {
        flag = false;
      }
      if (visited[nx][ny]) continue;
      if (height !== map[nx][ny]) continue;
      visited[nx][ny] = true;
      queue.push([nx, ny]);
    }
  }
}

let count = 0;
let visited = Array.from({ length: N }, () =>
  Array.from({ length: M }, () => false)
);
for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (!visited[i][j] && map[i][j] > 0) {
      visited[i][j] = true;
      flag = true;
      bfs(i, j, map[i][j]);
      if (flag) count++;
    }
  }
}

console.log(count);
