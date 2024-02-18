const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");

const [K, N] = input.shift().split(" ").map(Number);
const lans = input.map(Number);

let [start, end] = [1, Math.max(...lans)];
while (start <= end) {
  let center = Math.floor((start + end) / 2);
  let count = 0;
  for (let i = 0; i < K; i++) {
    count += Math.floor(lans[i] / center);
  }
  if (count < N) {
    end = center - 1;
  } else {
    start = center + 1;
  }
  console.log(start, end);
  console.log("cnt:", count);
}

console.log(end);
