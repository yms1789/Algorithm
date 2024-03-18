const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, M] = input[0];
let result = "";
let visited = Array(N + 1).fill(false);
function dfs(idx, depth, arr) {
  if (depth === M) {
    result += arr.join(" ") + "\n";
    return;
  }

  for (let i = 1; i <= N; i++) {
    if (!visited[i]) {
      arr.push(i);
      visited[i] = true;
      dfs(i + 1, depth + 1, arr);
      arr.pop();
      visited[i] = false;
    }
  }
}

dfs(1, 0, []);
console.log(result);
