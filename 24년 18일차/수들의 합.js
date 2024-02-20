const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

let S = input[0];

let start = 1;

while (start <= S) {
  S -= start;
  start++;
}

console.log(start - 1);
