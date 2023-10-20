const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n");
const N = Number(input.shift());

const friends = Array.from({length: N}, () =>
  Array.from({length: N}, () => Infinity)
);
for (let k = 0; k < N; k++) {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (i === j) continue;
      else {
        if (input[i][j] == "Y" || (input[i][k] == "Y" && input[k][j] == "Y")) {
          friends[i][j] = 1;
        }
      }
    }
  }
}

let res = 0;
for (let i = 0; i < N; i++) {
  let row = 0;
  for (let j = 0; j < N; j++) {
    if (i === j) continue;
    if (friends[i][j] === 1) row++;
  }
  res = Math.max(res, row);
}
console.log(res);
