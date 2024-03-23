const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");
const [N, M] = input[0].split(" ").map(Number);

let obj = {};
let result = "";
for (let i = 1; i < N + 1; i++) {
  let [addr, pw] = input[i].split(" ");

  obj[addr] = pw;
}

for (let i = N + 1; i < N + 1 + M; i++) {
  result += obj[input[i]] + "\n";
}

console.log(result);
