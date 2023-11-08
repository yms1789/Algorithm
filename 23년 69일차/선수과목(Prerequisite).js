const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, M] = input.shift();
// 어떤 과목은 선수과목이 있음
// 해당되는 모든 과목을 이수해야만 해당 과목을 이수할 수 있음
// 한 학기에 들을 수 있는 과목 수엔 제한이 X
// 모든 과목은 매 학기 항상 개설됨

// N: 과목 수, M: 선수 조건의 수
// A번 과목이 B번 과목의 선수과목
let curriculum = Array.from({ length: N + 1 }, () => []);
let preCourse = Array(N + 1).fill(0);
for (let i = 0; i < M; i++) {
  curriculum[input[i][1]].push(input[i][0]);
}
for (let i = 1; i < curriculum.length; i++) {
  let max = 0;
  if (curriculum[i].length)
    for (let j = 0; j < curriculum[i].length; j++) {
      max = Math.max(max, preCourse[curriculum[i][j]]);
    }
  preCourse[i] += max;
  preCourse[i]++;
}
console.log(preCourse.slice(1).join(" "));
