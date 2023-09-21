const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const [T, ...input] = stdin.split("\n");

for (let i = 0; i < T; i++) {
  let N = +input.shift();
  let stock = input
    .shift()
    .split(" ")
    .map(ele => Number(ele));
  let maxStock = stock[N - 1];
  let sum = 0;
  for (let i = N - 1; i >= 0; i--) {
    if (maxStock >= stock[i]) {
      sum += maxStock - stock[i];
    } else {
      maxStock = stock[i];
    }
  }
  console.log(sum);
}
