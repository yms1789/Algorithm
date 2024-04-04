const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));
let [N] = input[0];

let A = input[1];
let B = input[2];

A.sort((a, b) => a - b);
B.sort((a, b) => b - a);
let result = A.reduce((acc, curr, idx) => {
  return acc + curr * B[idx];
}, 0);

console.log(result);
