const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n");

let [l, w, h] = input.shift().split(" ").map(Number);
let N = parseInt(input.shift());
let result = 0;
let cubes = Array(20).fill(0);
for (let i = 0; i < input.length; i++) {
  let cubeInfo = input[i].split(" ").map(Number);
  cubes[cubeInfo[0]] = cubeInfo[1];
}

function nearestSquare(x) {
  let i = 1;
  while (2 ** i <= x) i += 1;
  return i - 1;
}

let size = 19;
size = nearestSquare(l);
size = Math.min(size, nearestSquare(w));
size = Math.min(size, nearestSquare(h));

let used = 0;

for (let i = size; i >= 0; i--) {
  used *= 8;
  let cur = 2 ** i;
  let required =
    parseInt(l / cur) * parseInt(w / cur) * parseInt(h / cur) - used;

  let usage = Math.min(required, cubes[i]);
  result += usage;
  used += usage;
}
if (used === l * w * h) console.log(res);
else console.log(-1);
