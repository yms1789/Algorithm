const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, T] = input[0];

const juryang = input.slice(1);
let [minSum, maxSum] = [0, 0];
let [left, right] = [1, 1];
for (let i = 0; i < N; i++) {
  minSum += juryang[i][0];
  maxSum += juryang[i][1];

  right = Math.max(right, juryang[i][1]);
}

if (T < minSum || maxSum < T) {
  console.log(-1);
  return;
}

let answer = Number.MAX_VALUE;

function isPossible(alcohol) {
  let minSum = 0;
  let temp = 0;

  for (let i = 0; i < N; i++) {
    if (juryang[i][0] > alcohol) return false;
    temp += Math.min(alcohol, juryang[i][1]) - juryang[i][0];
    minSum += juryang[i][0];
  }

  if (temp >= T - minSum) return true;
  return false;
}

while (left <= right) {
  let mid = parseInt((left + right) / 2);
  if (isPossible(mid)) {
    answer = Math.min(answer, mid);
    right = mid - 1;
  } else {
    left = mid + 1;
  }
}

console.log(answer);
