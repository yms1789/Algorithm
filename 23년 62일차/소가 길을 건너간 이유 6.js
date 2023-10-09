const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, K, R] = input.shift();

const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

let count = 0;

let roads = Array.from({ length: N + 1 }, () =>
  Array.from({ length: N + 1 }, () => [])
);

for (let i = 0; i < R; i++) {
  const [r, c, _r, _c] = input[i];
  roads[r][c].push([_r, _c].join(""));
  roads[_r][_c].push([r, c].join(""));
}
let cowDir = input.slice(R, R + K);
let visited = Array.from({ length: N + 1 }, () => Array(N + 1).fill(false));

function bfs(idx) {
  visited = Array.from({ length: N + 1 }, () => Array(N + 1).fill(false));
  let curCow = cowDir[idx];
  visited[curCow[0]][curCow[1]] = true;
  let queue = [curCow];
  while (queue.length) {
    let [cx, cy] = queue.shift();
    for (let i = 0; i < 4; i++) {
      let [nx, ny] = [cx + dx[i], cy + dy[i]];
      if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1 || visited[nx][ny])
        continue;
      if (roads[cx][cy].includes([nx, ny].join(""))) {
        // 길을 건넘
        continue;
      }
      visited[nx][ny] = true;
      queue.push([nx, ny]);
    }
  }
}
for (let i = 0; i < cowDir.length; i++) {
  bfs(i);
  for (let j = i + 1; j < cowDir.length; j++) {
    if (!visited[cowDir[j][0]][cowDir[j][1]]) count++;
  }
}
console.log(count);
