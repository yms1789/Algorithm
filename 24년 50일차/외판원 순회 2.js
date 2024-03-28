const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N] = input.shift();

let minCost = Number.MAX_VALUE;
function dfs(depth, visited, arr) {
  if (depth === N) {
    if (calcCost(arr)) minCost = Math.min(minCost, calcCost(arr));
    return;
  }

  for (let i = 0; i < N; i++) {
    if (!visited[i]) {
      visited[i] = true;
      arr.push(i);
      dfs(depth + 1, visited, arr);
      visited[i] = false;
      arr.pop();
    }
  }
}

function calcCost(arr) {
  let sum = 0;
  let [c, n] = [0, 1];
  for (let i = 0; i < arr.length; i++) {
    let [cc, nn] = [arr[(c + i) % N], arr[(n + i) % N]];
    if (input[cc][nn] === 0) {
      return false;
    }
    sum += input[cc][nn];
  }
  return sum;
}

let visited = Array(N).fill(false);
dfs(0, visited, []);

console.log(minCost);
