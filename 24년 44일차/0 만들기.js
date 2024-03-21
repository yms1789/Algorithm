const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [T] = input[0];

let N;
let oprs = [" ", "+", "-"];
let numbers;
function dfs(depth, arr) {
  let str = "";
  if (depth === N - 1) {
    for (let j = 0; j < N - 1; j++) str += numbers[j] + arr[j];
    str += numbers[N - 1] + "";
    if (eval(str.split(" ").join("")) === 0) console.log(str);
    return;
  }

  for (let opr of oprs) {
    arr.push(opr);
    dfs(depth + 1, arr);
    arr.pop();
  }
}

for (let i = 1; i <= T; i++) {
  N = input[i][0];
  numbers = Array.from({ length: N }, (_, i) => i + 1);
  dfs(0, []);
  console.log();
}
