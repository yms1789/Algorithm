const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));
const [T] = input.shift();
let dx = [1, -1, 0, 0];
let dy = [0, 0, 1, -1];
for (let i = 0; i < input.length; ) {
  let [M, N, K] = input[i];
  const board = Array.from({ length: M }, () =>
    Array.from({ length: N }, () => 0)
  );
  let map = input.slice(i + 1, i + K + 1);
  i += K + 1;

  let count = 0;

  for (let a = 0; a < K; a++) {
    board[map[a][0]][map[a][1]] = 1;
  }
  let visited = Array.from({ length: M }, () =>
    Array.from({ length: N }, () => false)
  );

  for (let x = 0; x < M; x++) {
    for (let y = 0; y < N; y++) {
      if (!visited[x][y] && board[x][y] === 1) {
        count++;
        dfs(x, y, board, visited, M, N);
      }
    }
  }
  console.log(count);
}

function dfs(cx, cy, board, visited, M, N) {
  visited[cx][cy] = true;
  for (let d = 0; d < 4; d++) {
    let [nx, ny] = [cx + dx[d], cy + dy[d]];
    if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny]) continue;
    if (board[nx][ny] === 0) continue;
    visited[nx][ny] = true;
    dfs(nx, ny, board, visited, M, N);
  }
}
