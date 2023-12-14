const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));
const N = input.shift()[0];
let seq = input[0];
seq.sort();
let sum = seq.reduce((acc, cur) => acc + cur, 0);
let arr = Array(sum + 2).fill(0);
let sub = [];
function dfs(idx) {
  if (idx === N) {
    let hap = sub.reduce((acc, curr) => acc + curr, 0);
    arr[hap] = 1;
    return;
  }

  sub.push(seq[idx]);
  dfs(idx + 1);
  sub.pop();
  dfs(idx + 1);
}
dfs(0);
console.log(arr.indexOf(0));
