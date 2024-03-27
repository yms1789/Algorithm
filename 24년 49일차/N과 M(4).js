const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split(" ").map(Number);

let [N, M] = input;
let result = "";
function dfs(idx, depth, arr) {
  if (depth === M) {
    result += arr.join(" ") + "\n";
    return;
  }

  for (let i = idx; i <= N; i++) {
    arr.push(i);
    dfs(i, depth + 1, arr);
    arr.pop();
  }
}

dfs(1, 0, []);

console.log(result);
