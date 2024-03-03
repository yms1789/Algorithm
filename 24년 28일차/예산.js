const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

let N = input[0];
let yesan = input[1];
let hap = input[2];

// 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정
// 모든 요청이 배정 X => 특정 정수 상한액을 계산해서 그 이상인 예산 요청에는 모두 상한액을 배정
let result = 0;
let sum = yesan.reduce((acc, cur) => acc + cur, 0);
yesan.sort((a, b) => a - b);
if (sum <= hap) {
  console.log(yesan.at(-1));
} else {
  let [left, right] = [0, yesan.at(-1)];
  while (left <= right) {
    let mid = parseInt((left + right) / 2);
    let modify = 0;

    yesan.forEach((ele) => {
      modify += Math.min(ele, mid);
    });

    if (modify > hap) {
      right = mid - 1;
      result = right;
    } else {
      left = mid + 1;
    }
  }
  console.log(right);
}
