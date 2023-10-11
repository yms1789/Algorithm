const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();
const input = stdin.split("\n").map(ele => ele.split(" ").map(Number));

let dx = [1, -1, 0, 0];
let dy = [0, 0, 1, -1];

let maxValue = 0;
const N = input.shift()[0];

input.forEach(ele => {
  maxValue = Math.max(maxValue, ...ele);
});
let maxSafety = 1;
let safetyCount;
let visited = Array.from({length: N}, () => Array(N).fill(false));

for (let height = 1; height < maxValue; height++) {
  visited = Array.from({length: N}, () => Array(N).fill(false));
  safetyCount = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (!visited[i][j] && input[i][j] > height) {
        bfs(i, j, height);
      }
    }
  }
  maxSafety = Math.max(safetyCount, maxSafety);
}

function bfs(x, y, height) {
  let queue = [[x, y]];
  visited[x][y] = true;
  while (queue.length) {
    let [cx, cy] = queue.shift();
    for (let i = 0; i < 4; i++) {
      let [nx, ny] = [cx + dx[i], cy + dy[i]];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
      if (input[nx][ny] <= height) continue;
      visited[nx][ny] = true;
      queue.push([nx, ny]);
    }
  }
  safetyCount++;
}

console.log(maxSafety);
