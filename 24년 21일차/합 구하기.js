const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n");

let [N] = input[0];
const arr = input[1].split(" ").map(Number);
let [M] = input[2];
[N, M] = [parseInt(N), parseInt(M)];

let pre = [arr[0]];
let result = [];

for (let i = 1; i < arr.length; i++) {
  pre[i] = pre[i - 1] + arr[i];
}

let gugan = input.splice(3).map((ele) => ele.split(" ").map(Number));
for (let i = 0; i < M; i++) {
  let a = gugan[i][0] - 1;
  let b = gugan[i][1] - 1;
  let sum = a === 0 ? pre[b] : pre[b] - pre[a - 1];

  result.push(sum);
}
console.log(result.join("\n"));
