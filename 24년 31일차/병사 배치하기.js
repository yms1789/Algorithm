const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N] = input[0];
const soldiers = input[1];

let result = [soldiers[0]];
for (let i = 1; i < N; i++) {
  if (result.at(-1) > soldiers[i]) {
    result.push(soldiers[i]);
  } else {
    let idx = 0;
    while (idx < i) {
      if (result[idx] < soldiers[i]) {
        result[idx] = soldiers[i];
        break;
      } else idx++;
    }
  }
}

console.log(N - result.length);
