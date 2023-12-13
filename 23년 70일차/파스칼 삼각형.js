const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();
const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));
let pascal = [[1], [1, 1]];
let [R, C, W] = input[0];
for (let i = 2; i < R + W; i++) {
  let row = [1];
  for (let j = 1; j < i; j++) {
    row.push(pascal[i - 1][j - 1] + pascal[i - 1][j]);
  }
  row.push(1);
  pascal.push(row);
}

let hap = 0;
for (let i = 0; i < W; i++) {
  hap += pascal[R + i - 1]
    .slice(C - 1, C + i)
    .reduce((acc, cur) => acc + cur, 0);
}
console.log(hap);
