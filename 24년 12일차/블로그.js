const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, X] = input.shift();

let maxVisit = 0;
let visitor = input[0];
let cnt = 1;

for (let i = 0; i < X; i++) {
  maxVisit += visitor[i];
}
let temp = maxVisit;
for (let i = X; i < N; i++) {
  temp = temp - visitor[i - X] + visitor[i];
  if (temp === maxVisit) cnt++;
  else if (temp > maxVisit) {
    maxVisit = temp;
    cnt = 1;
  }
}
console.log(
  visitor.reduce((acc, cur) => acc + cur, 0) === 0
    ? "SAD"
    : `${maxVisit}\n${cnt}`
);
