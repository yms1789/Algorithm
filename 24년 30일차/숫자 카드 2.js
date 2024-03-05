const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

let [N] = input[0];
let cards = input[1];
let [M] = input[2];
let counts = input[3];

cards.sort((a, b) => a - b);

function lowerBound(left, right, target) {
  while (left < right) {
    let mid = parseInt((left + right) / 2);
    if (cards[mid] >= target) {
      right = mid;
    } else left = mid + 1;
  }
  return right;
}

function upperBound(left, right, target) {
  while (left < right) {
    let mid = parseInt((left + right) / 2);
    if (cards[mid] > target) {
      right = mid;
    } else left = mid + 1;
  }
  return right;
}
let result = [];
for (let i = 0; i < M; i++) {
  result.push(upperBound(0, N, counts[i]) - lowerBound(0, N, counts[i]));
}

console.log(result.join(" "));
