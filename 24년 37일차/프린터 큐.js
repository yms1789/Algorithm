const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [T] = input.shift();
let answer = [];
function solution(N, M, priority) {
  let count = 0;
  while (true) {
    let maxPriority = Math.max(...priority);
    let popDoc = priority.shift();
    if (popDoc === maxPriority) {
      count++;
      if (M === 0) {
        answer.push(count);
        break;
      }
    } else {
      priority.push(popDoc);
    }
    if (M === 0) M = priority.length - 1;
    else M--;
  }
}

for (let i = 0; i < input.length; i += 2) {
  let [N, M] = input[i];
  let priority = input[i + 1];
  solution(N, M, priority);
}

console.log(answer.join("\n"));
