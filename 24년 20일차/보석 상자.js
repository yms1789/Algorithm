const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");

const [N, M] = input.shift().split(" ").map(Number);

let jewelry = input.map(Number);

// 1. 모든 보석을 N명의 학생에게 줌
// 2. 보석을 받지 못하는 학생이 있어도 OK
// 3. 한 학생은 항상 같은 색상의 보석만

// 질투심: 가장 많은 보석을 가져간 학생이 가져간 보석 개수

let [low, high] = [1, Math.max(...jewelry)];

let jealousy = Number.MAX_VALUE;
while (low <= high) {
  let mid = Math.floor((low + high) / 2);
  let sum = 0;

  for (let jew of jewelry) {
    let people =
      jew % mid === 0 ? Math.floor(jew / mid) : Math.floor(jew / mid) + 1;
    sum += people;
  }
  if (N >= sum) {
    jealousy = Math.min(jealousy, mid);
    high = mid - 1;
  } else {
    low = mid + 1;
  }
}

console.log(jealousy);
