const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map(Number);
const [N, K] = input;

// 현재 mid보다 작거나 같은 데이터의 수가 K개 이상이 되는 조건을 만족하는 mid중에서 가장 작은 값

let [left, right] = [1, Math.pow(N, 2)];
let answer = N * N;
while (left <= right) {
  let mid = parseInt((left + right) / 2);

  if (isMoreK(mid)) {
    answer = Math.min(answer, mid);
    right = mid - 1;
  } else {
    left = mid + 1;
  }
}

function isMoreK(mid) {
  let count = 0;
  for (let i = 1; i <= N; i++) {
    count += Math.min(parseInt(mid / i), N);
  }
  if (count >= K) {
    return true;
  } else {
    return false;
  }
}

console.log(answer);
