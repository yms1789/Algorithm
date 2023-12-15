const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => Number(ele));
const [N, K] = [input[0], input[1]];
const cards = input.slice(2);
let making = [];
let visited = Array(N).fill(false);
let count = 0;
function combi(idx, depth, arr = []) {
  if (depth === K) {
    let num = arr.join("");
    making.push(num);
    return;
  }
  for (let i = 0; i < N; i++) {
    if (!visited[i]) {
      arr.push(cards[i]);
      visited[i] = true;
      combi(i + 1, depth + 1, arr);
      arr.pop();
      visited[i] = false;
    }
  }
}

combi(0, 0);
making = [...new Set(making)];
console.log(making.length);
