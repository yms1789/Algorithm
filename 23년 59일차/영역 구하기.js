const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(ele => ele.split(" ").map(Number));

const [M, N, K] = input.shift();
let map = Array.from({length: M}, () => {
  return Array(N).fill(0);
});

let visited = Array.from({length: M}, () => {
  return Array(N).fill(false);
});

let dx = [1, -1, 0, 0];
let dy = [0, 0, 1, -1];

let answer = [];

function bfs(i, j) {
  let queue = [[i, j]];
  visited[i][j] = true;
  let count = 1;
  while (queue.length) {
    let [cx, cy] = queue.shift();
    for (let i = 0; i < 4; i++) {
      let [nx, ny] = [cx + dx[i], cy + dy[i]];
      if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny]) continue;

      if (map[nx][ny] === 0) {
        visited[nx][ny] = true;
        queue.push([nx, ny]);
        count++;
      }
    }
  }
  if (count) {
    answer.push(count);
  }
}

for (let k = 0; k < K; k++) {
  let [lby, lbx, rty, rtx] = input[k];
  // (1, 1) -> (3, 1)
  let [tbx, tby, ttx, tty] = [M - lbx - 1, lby, M - rtx, rty];
  for (let i = 0; i < M; i++) {
    for (let j = 0; j < N; j++) {
      if (ttx <= i && tby <= j && i <= tbx && j < tty) {
        map[i][j] = 1;
      }
    }
  }
}

for (let i = 0; i < M; i++) {
  for (let j = 0; j < N; j++) {
    if (!visited[i][j] && !map[i][j]) {
      bfs(i, j);
    }
  }
}
console.log(`${answer.length}\n${answer.sort((a, b) => a - b).join(" ")}`);
