const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));
let [N, M] = input[0];

let map = input.slice(1);

let dx = [1, -1, 0, 0];
let dy = [0, 0, 1, -1];
// 0은 빈 칸, 1은 집, 2는 치킨집

let chickenDir = [];
let house = [];
for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (map[i][j] === 2) chickenDir.push([i, j]);
    if (map[i][j] === 1) house.push([i, j]);
  }
}

let selected = Array(chickenDir.length).fill(false);

let result = Number.MAX_VALUE;

function dfs(idx, depth, arr) {
  if (depth === M) {
    calc(arr);
    return;
  }
  for (let i = idx; i < chickenDir.length; i++) {
    if (!selected[i]) {
      selected[i] = true;
      arr.push(chickenDir[i]);
      dfs(i + 1, depth + 1, arr);
      selected[i] = false;
      arr.pop();
    }
  }
}

dfs(0, 0, []);

// 치킨 집을 골랐을 때 각 치킨 집에 대한 치킨 거리를 구하자

function calc(chickens) {
  let chickenLen = 0;
  for (let i = 0; i < house.length; i++) {
    let len = N * N;
    for (let j = 0; j < chickens.length; j++) {
      let [hx, hy] = [house[i][0], house[i][1]];
      let [chx, chy] = [chickens[j][0], chickens[j][1]];
      len = Math.min(len, Math.abs(chx - hx) + Math.abs(chy - hy));
    }
    chickenLen += len;
  }
  result = Math.min(result, chickenLen);
}

console.log(result);
