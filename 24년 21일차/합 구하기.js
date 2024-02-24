const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n");

let N = parseInt(input[0]);
const arr = input[1].split(" ").map((ele) => Number(ele));
let M = parseInt(input[2]);

let pre = Array(N + 1).fill(0);

let result = [];
for (let i = 1; i <= arr.length; i++) {
  pre[i] = pre[i - 1] + arr[i - 1];
}

for (let i = 0; i < M; i++) {
  let [a, b] = input[i + 3].split(" ");
  let sum = pre[b] - pre[a - 1];
  result.push(sum);
}
console.log(result.join("\n"));
