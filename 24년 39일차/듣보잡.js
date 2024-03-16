const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");
const [N, M] = input[0].split(" ").map(Number);
let notListenNames = input.slice(1, N + 1);
let notSeeingNames = input.slice(N + 1, N + M + 1);

let obj = {};

for (let i = 0; i < notListenNames.length; i++) {
  obj[notListenNames[i]] = (obj[notListenNames[i]] || 0) + 1;
}
for (let i = 0; i < notSeeingNames.length; i++) {
  obj[notSeeingNames[i]] = (obj[notSeeingNames[i]] || 0) + 1;
}
let notListenSeeingNames = Object.entries(obj);
let answer = [];
for (let i = 0; i < notListenSeeingNames.length; i++) {
  if (notListenSeeingNames[i][1] === 2) answer.push(notListenSeeingNames[i][0]);
}

console.log(answer.length);
console.log(answer.sort().join("\n"));
