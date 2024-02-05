const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");

const T = Number(input[0]);
const alpha = input.slice(1);

function nextPerm(arr) {
  let i = arr.length - 2;
  while (i >= 0 && arr[i] >= arr[i + 1]) i -= 1;

  if (i === -1) return false;

  let j = arr.length - 1;
  while (arr[i] >= arr[j]) j -= 1;

  [arr[i], arr[j]] = [arr[j], arr[i]];
  let res = arr.slice(0, i + 1);
  res = res.concat(arr.slice(i + 1).reverse());
  return res;
}

for (let i = 0; i < T; i++) {
  let answer = nextPerm(alpha[i].split(""));
  if (!answer) {
    console.log(alpha[i]);
  } else {
    console.log(answer.join(""));
  }
}
