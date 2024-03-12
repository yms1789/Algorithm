const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, M] = input[0];

const map = input.slice(1);

let range = Array.from({ length: N }, () => Array.from({ length: M }, () => 0));
let visited = Array.from({ length: N }, () =>
  Array.from({ length: M }, () => false)
);
let dx = [1, -1, 0, 0];
let dy = [0, 0, 1, -1];

function bfs(start) {
  let queue = [start];
  while (queue.length) {
    let [cx, cy] = queue.shift();
    for (let d = 0; d < 4; d++) {
      let [nx, ny] = [cx + dx[d], cy + dy[d]];
      if (nx < 0 || ny < 0 || nx >= N || ny >= M || range[nx][ny] > 0) continue;

      if (map[nx][ny] === 0) {
        range[nx][ny] = 0;
        visited[nx][ny] = true;
        continue;
      }

      queue.push([nx, ny]);
      range[nx][ny] = range[cx][cy] + 1;
      visited[nx][ny] = true;
    }
  }
}
let start = [];
for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (map[i][j] === 2) {
      start = [i, j];
      visited[i][j] = true;
      break;
    }
  }
}
bfs(start);

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (!visited[i][j] && map[i][j] > 0) {
      range[i][j] = -1;
    }
  }
}

range[start[0]][start[1]] = 0;

for (let i = 0; i < N; i++) {
  console.log(range[i].join(" "));
}
