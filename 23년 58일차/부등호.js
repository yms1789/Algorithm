const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" "));
const k = Number(input[0]);
const inequalities = input[1];
function isMatch(arr) {
  for (let i = 0; i < k; i++) {
    if (inequalities[i] === ">") {
      if (arr[i] < arr[i + 1]) {
        return false;
      }
    }
    if (inequalities[i] === "<") {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }
  }
  return true;
}
let visited = Array(10).fill(false);
let maxNum = 0;
let minNum = Number.MAX_VALUE;
function perm(depth, arr, n) {
  if (depth === inequalities.length + 1) {
    if (isMatch(arr)) {
      maxNum = Math.max(maxNum, Number(arr.join("")));
      minNum = Math.min(minNum, Number(arr.join("")));
    }
    return;
  }
  for (let i = 0; i <= 9; i++) {
    if (!visited[i]) {
      arr.push(i);
      visited[i] = true;
      perm(depth + 1, arr);
      arr.pop();
      visited[i] = false;
    }
  }
}

perm(0, []);
if ((minNum + "").length - 1 !== k) {
  minNum = `0${minNum}`;
}
console.log(`${maxNum}\n${minNum}`);
