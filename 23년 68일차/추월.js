const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();
let [N, ...input] = stdin.split("\n");
N = +N;

let [inCar, outCar] = [input.slice(0, N), input.slice(N)];

let priority = [];
for (let i = 0; i < outCar.length; i++) {
  priority.push(inCar.indexOf(outCar[i]));
}
let count = 0;

for (let i = 0; i < N; i++) {
  if (inCar[i] !== outCar[i]) {
    count++;
    inCar.splice(inCar.indexOf(outCar[i]), 1);
    outCar.splice(i, 1);
    i--;
  }
}
console.log(count);
