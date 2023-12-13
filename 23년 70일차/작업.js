const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();
let input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));
const N = input[0][0];

let graph = Array.from(Array(N + 1), () => Array());
let indegree = new Array(N + 1).fill(0);
let time = new Array(N + 1);

for (let i = 1; i <= N; i++) {
  let workInfo = input[i];
  time[i] = workInfo[0];
  if (workInfo[1] !== 0) {
    for (let j = 2; j < workInfo.length; j++) {
      graph[workInfo[j]].push(i);
      indegree[i]++;
    }
  }
}

let queue = [];
let dp = Array(N + 1).fill(0);
for (let i = 1; i <= N; i++) {
  if (indegree[i] === 0) {
    queue.push(i);
    dp[i] = time[i];
  }
}
while (queue.length) {
  let x = queue.shift();
  for (let next of graph[x]) {
    indegree[next]--;
    dp[next] = Math.max(dp[next], dp[x] + time[next]);
    if (indegree[next] === 0) queue.push(next);
  }
}
console.log(Math.max(...dp));
