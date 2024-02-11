const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, K] = input.shift();
const arr = input[0];

let [start, end] = [0, 0];
const dolls = { 1: 0, 2: 0 };
let cnt = Number.MAX_VALUE;
while (start <= end && end < N) {
  if (dolls["1"] < K) {
    dolls[arr[end]] = (dolls[arr[end]] || 0) + 1;
  }
  while (dolls["1"] === K) {
    dolls[arr[start]]--;
    cnt = Math.min(cnt, end - start + 1);
    start++;
  }
  end++;
}

console.log(cnt === Number.MAX_VALUE ? -1 : cnt);
