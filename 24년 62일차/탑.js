const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N] = input[0];
const tops = input[1];

let stack = [[tops.at(-1), N - 1]];

let result = Array(N).fill(0);
for (let i = tops.length - 2; i >= 0; i--) {
  if (stack.at(-1) > tops[i]) {
    stack.push([tops[i], i]);
  } else {
    while (stack.at(-1)?.[0] <= tops[i]) {
      let top = stack.pop();
      result[top[1]] = i + 1;
    }
    stack.push([tops[i], i]);
  }
}
console.log(result.join(" "));
