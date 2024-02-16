const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

// 두 파일이 있을 때 작은 파일의 크기가 큰 파일 크기의 90%보다도 작으면 해당 쌍은 검사 없이 넘어감
// i != j 이고 F_i <= F_j 이고 F_i >= F_j * 0.9 인 것만 검사

let N = input.shift()[0];

let files = input[0];

let count = 0;
files.sort((a, b) => a - b);

for (let i = 0; i < N; i++) {
  let [left, right] = [i, N - 1];
  while (left <= right) {
    let center = Math.floor((left + right) / 2);
    if (files[i] >= files[center] * 0.9) {
      left = center + 1;
    } else {
      right = center - 1;
    }
  }
  count += left - i - 1;
}

console.log(count);
