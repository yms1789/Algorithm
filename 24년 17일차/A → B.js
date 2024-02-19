const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

let [A, B] = input[0];

function bfs() {
  let queue = [[A, 1]];
  while (queue.length) {
    let cur = queue.shift();
    for (let i = 0; i < 2; i++) {
      let next;
      if (i === 0) {
        next = [Number(cur[0] + "1"), cur[1] + 1];
      }
      if (i === 1) {
        next = [cur[0] * 2, cur[1] + 1];
      }
      if (next[0] === B) {
        return next[1];
      }
      if (next[0] > B) continue;
      if (next[0] < B) {
        queue.push(next);
      }
    }
  }
  return false;
}
console.log(bfs() === false ? -1 : bfs());
