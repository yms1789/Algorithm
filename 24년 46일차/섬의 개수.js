const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");
let dx = [-1, -1, 0, 1, 1, 1, 0, -1];
let dy = [0, 1, 1, 1, 0, -1, -1, -1];

function bfs(map, visited, cur, w, h) {
  let queue = [cur];
  while (queue.length) {
    let [cx, cy] = queue.shift();

    for (let d = 0; d < 8; d++) {
      let [nx, ny] = [cx + dx[d], cy + dy[d]];
      if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny]) continue;
      if (map[nx][ny]) {
        visited[nx][ny] = true;
        queue.push([nx, ny]);
      }
    }
  }
}

for (let i = 0; i < input.length; ) {
  let [w, h] = input[i].split(" ").map(Number);
  if ((w === 0) & (h === 0)) break;
  let map = input
    .slice(i + 1, i + h + 1)
    .map((ele) => ele.split(" ").map(Number));

  let visited = Array.from({ length: h }, () =>
    Array.from({ length: w }, () => false)
  );
  let count = 0;
  for (let a = 0; a < h; a++) {
    for (let b = 0; b < w; b++) {
      if (map[a][b] && !visited[a][b]) {
        bfs(count, map, visited, [a, b], w, h);
        count++;
      }
    }
  }
  console.log(count);
  i += h + 1;
}
