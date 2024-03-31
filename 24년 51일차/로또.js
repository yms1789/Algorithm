const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

let result = "";

function dfs(idx, depth, len, visited, lotto, arr) {
  if (depth === 6) {
    result += arr.join(" ") + "\n";
    return;
  }

  for (let i = idx; i < len; i++) {
    if (!visited[i]) {
      visited[i] = true;
      arr.push(lotto[i]);
      dfs(i + 1, depth + 1, len, visited, lotto, arr);
      visited[i] = false;
      arr.pop();
    }
  }
}

for (let i = 0; input[i][0] !== 0; i++) {
  let [k, lotto] = [input[i][0], input[i].slice(1)];
  let visited = Array(k).fill(false);
  dfs(0, 0, k, visited, lotto, []);
  result += "\n";
}

console.log(result);
