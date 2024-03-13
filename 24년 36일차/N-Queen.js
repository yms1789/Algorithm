const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(Number);

const [N] = input;

let queens = [];

function possible(x, y) {
  for (let i = 0; i < queens.length; i++) {
    let [a, b] = queens[i];
    if (a === x || b === y) return false;
    if (Math.abs(a - x) === Math.abs(b - y)) return false;
  }

  return true;
}

let count = 0;
function dfs(row) {
  if (row === N) count += 1;
  for (let i = 0; i < N; i++) {
    if (!possible(row, i)) continue;
    queens.push([row, i]);
    dfs(row + 1);
    queens.pop();
  }
}

dfs(0);

console.log(count);
