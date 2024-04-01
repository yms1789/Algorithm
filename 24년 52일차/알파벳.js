const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");

const [R, C] = input.shift().split(" ").map(Number);

let board = input.map((ele) => ele.split(""));
let result = 0;

let dx = [1, -1, 0, 0];
let dy = [0, 0, 1, -1];
let visitAlpha = Array(26).fill(false);

let count = 1;
function dfs(cx, cy) {
  for (let i = 0; i < 4; i++) {
    let [nx, ny] = [cx + dx[i], cy + dy[i]];
    if (
      nx < 0 ||
      ny < 0 ||
      nx >= R ||
      ny >= C ||
      visitAlpha[board[nx][ny].charCodeAt - 65]
    )
      continue;
    count++;
    visitAlpha[board[nx][ny].charCodeAt - 65] = true;
    dfs(nx, ny);
    visitAlpha[board[nx][ny].charCodeAt - 65] = false;
    count--;
  }
  result = Math.max(count, result);
}

function isVisit(alpha) {
  if (visitAlpha.includes(alpha)) return true;
  return false;
}

visitAlpha.push(board[0][0]);
dfs(0, 0);

console.log(result);
