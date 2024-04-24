const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N] = input[0];

const map = input.slice(1);

// 처음 아기 상어의 크기 = 2, 1초마다 상하좌우로 인접한 한 칸씩 이동함
// 아기상어는 자신보다 큰 놈은 못 지나감, 크키가 작은 물고기만 먹을 수 있다
// if) 2라면 2는 먹을 수는 없지만 지나갈 수는 있음
// 이동 결정
/**
 * 1. 더 이상 먹을 수 있는 물고기가 공간에 없으면 도움 요청
 * 2. 먹을 수 있는 물고기가 1마리면 그 물고기 먹으러 감
 * 3. 1마리 이상이면 가장 가까운 물고기 먹으러 감
 * 4. 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
 */

let dx = [-1, 0, 0, 1];
let dy = [0, -1, 1, 0];
let baby = 2;
let count = 0;
let eat = 0;
let minX, minY, minR;
function bfs(range, queue) {
  while (queue.length) {
    let [cx, cy] = queue.shift();
    for (let d = 0; d < 4; d++) {
      let [nx, ny] = [cx + dx[d], cy + dy[d]];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
      if (baby < map[nx][ny]) continue;
      if (range[nx][ny] !== 0) continue;
      range[nx][ny] = range[cx][cy] + 1;
      if (baby > map[nx][ny] && map[nx][ny] !== 0) {
        if (minR > range[nx][ny]) {
          // 새로운 칸이 최소 거리라면
          minX = nx;
          minY = ny;
          minR = range[nx][ny];
        } else if (minR === range[nx][ny]) {
          if (minX === nx) {
            if (minY > ny) {
              minY = ny;
            }
          } else if (minX > nx) {
            minX = nx;
            minY = ny;
          }
        }
      }
      queue.push([nx, ny]);
    }
  }
}

let start;

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (map[i][j] === 9) {
      map[i][j] = 0;
      start = [i, j];
    }
  }
}

while (true) {
  [minX, minY, minR] = [Number.MAX_VALUE, Number.MAX_VALUE, Number.MAX_VALUE];
  let range = Array.from({ length: N }, () =>
    Array.from({ length: N }, () => 0)
  );
  let queue = [start];
  bfs(range, queue);

  if (minX !== Number.MAX_VALUE && minY !== Number.MAX_VALUE) {
    eat++;
    map[minX][minY] = 0;
    start = [minX, minY];
    count += range[minX][minY];
    if (eat === baby) {
      eat = 0;
      baby++;
    }
  } else break;
}

console.log(count);
