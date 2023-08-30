/* 
  solution
  - bfs를 통해 인접한 집들의 모임인 단지의 수를 구하자!
  - 입력값을 순회하면서 집이 있는 곳이라면 방문처리
    - 해당 지점부터 시작해서 더 이상 인접한 집이 없을 때 까지 반복
    - 방문한 집이 처음 시작한 집 번호랑 같은경우만 queue에 추가하자
      - 인접한 집의 단지번호가 다를 수 있으므로
  - 더 이상 방문할 곳이 없다면 단지 수와 단지 내 집의 수를 오름차순 정렬  후 출력
*/

const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let [N, ...input] = stdin.split("\n");
N = Number(N);
input = input.map((ele) => ele.split("").map(Number));

let danji = 0;
let visited = Array.from({ length: N }, () => Array(N).fill(false));
let dx = [1, -1, 0, 0];
let dy = [0, 0, 1, -1];

let answer = [];

function bfs(i, j, cNum) {
  let queue = [[i, j]];
  visited[i][j] = true;
  let house = 1;
  while (queue.length) {
    let [cx, cy] = queue.shift();
    for (let i = 0; i < 4; i++) {
      let [nx, ny] = [cx + dx[i], cy + dy[i]];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

      if (input[nx][ny] === cNum) {
        queue.push([nx, ny]);
        visited[nx][ny] = true;
        house++;
      }
    }
  }
  answer.push(house);
}

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (!visited[i][j] && input[i][j] > 0) {
      bfs(i, j, input[i][j]);

      danji++;
    }
  }
}

answer.sort((a, b) => a - b);
answer.unshift(danji);

console.log(answer.join("\n"));
