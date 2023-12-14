const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(Number);
let n = input[0];
let [left, right] = [0, n];

while (left <= right) {
  let mid = Math.floor((left + right) / 2);
  if (mid ** 2 < n) left = mid + 1;
  else right = mid - 1;
}
console.log(left);
