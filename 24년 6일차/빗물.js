const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [H, W] = input[0];
const blocks = input[1];

function findLeftRightMax(idx) {
  let [left, right] = [blocks[idx], blocks[idx]];
  for (let i = idx - 1; i >= 0; i--) {
    left = Math.max(blocks[i], left);
  }

  for (let i = idx; i < blocks.length; i++) {
    right = Math.max(blocks[i], right);
  }
  return [left, right];
}
let count = 0;
for (let i = 0; i < blocks.length; i++) {
  let [left, right] = findLeftRightMax(i);
  count += Math.min(left, right) - blocks[i];
}

console.log(count);
