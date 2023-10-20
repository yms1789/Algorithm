const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n");
const N = input.shift();
input = input.map(ele =>
  ele
    .split("")
    .filter(ele => ele !== "\r")
    .join("")
);

input.sort();

let stack = [];
stack.push(input[0]);
for (let i = 1; i < input.length; i++) {
  if (
    stack[stack.length - 1] !==
    input[i].slice(0, stack[stack.length - 1].length)
  ) {
    stack.push(input[i]);
  } else {
    stack.pop();
    stack.push(input[i]);
  }
}
console.log(stack.length);
