const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split(" ").map(Number);

let [N, M] = input;
let result = [];
let visited = Array(N + 1).fill(false);
function dfs(depth, arr) {
  if (arr.length === M) {
    let sortArr = [...arr];
    sortArr.sort();
    if (sortArr.join("") === arr.join("")) result.push(arr.join(" "));
    return;
  }

  for (let i = 1; i <= N; i++) {
    if (!visited[i]) {
      visited[i] = true;
      arr.push(i);
      dfs(depth + 1, arr);
      visited[i] = false;
      arr.pop();
    }
  }
}

dfs(1, []);

for (let i = 0; i < result.length; i++) {
  console.log(result[i]);
}
