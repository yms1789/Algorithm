const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

let N = input[0][0];
let water = input[1];

let [left, right] = [0, N - 1];
let [resLeft, resRight] = [0, 0];
let diff = Number.MAX_VALUE;
while (left < right) {
  let mix = water[left] + water[right];
  if (diff >= Math.abs(mix)) {
    diff = Math.abs(mix);
    [resLeft, resRight] = [water[left], water[right]];
  }
  if (mix < 0) {
    left += 1;
  } else {
    right -= 1;
  }
}

console.log(resLeft, resRight);
