const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N] = input.shift();

// 한 개의 회의실에 대해 N개의 회의
// 회의실 사용표를 만듦
// 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대의 개수
// 회의가 끝나는 것과 동시에 시작할 수도 있음

let lastMeeting = Math.max(...input.map((ele) => ele[1]));
input.sort((a, b) => {
  if (a[1] === b[1]) return a[0] - b[0];
  return a[1] - b[1];
});

let result = 1;
let curMeet = input[0];
for (let i = 1; i < N; i++) {
  if (input[i][0] >= curMeet[1]) {
    curMeet = input[i];
    result++;
  }
}
console.log(result);
