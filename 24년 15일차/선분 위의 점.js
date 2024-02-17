const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, M] = input.shift();
const coords = input.shift();

coords.sort((a, b) => a - b);

let result = [];

for (let i = 0; i < input.length; i++) {
  let [start, end] = [0, coords.length - 1];
  while (start <= end) {
    let center = Math.floor((start + end) / 2);
    if (coords[center] < input[i][0]) {
      start = center + 1;
    } else {
      end = center - 1;
    }
  }
  let sIdx = start;
  [start, end] = [0, coords.length - 1];
  while (start <= end) {
    let center = Math.floor((start + end) / 2);
    if (coords[center] > input[i][1]) {
      end = center - 1;
    } else {
      start = center + 1;
    }
  }
  let eIdx = end;
  result.push(eIdx - sIdx + 1);
}

console.log(result.join("\n"));
