const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, K] = input.shift();
const arr = input[0];
let [start, end] = [0, 0];
let numCnt = {};
let result = 0;
while (start <= end && end < N) {
  while (numCnt[arr[end]] === K) {
    numCnt[arr[start]]--;
    start++;
  }
  result = Math.max(result, end - start + 1);
  numCnt[arr[end]] = (numCnt[arr[end]] || 0) + 1;
  end++;
}
console.log(result);
