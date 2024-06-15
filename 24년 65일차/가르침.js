const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");
let [N, K] = input.shift().split(" ").map(Number);
const presuff = ["a", "n", "t", "i", "c"];
let alphaList = Array(26).fill(false);
presuff.forEach((ele) => {
  alphaList[ele.charCodeAt() - 97] = true;
});
// 학생들은 K개의 글자로 이루어진 단어만 읽을 수 있음
// 남극언어 단어는 N개 밖에 없음
// 남극 언어의 모든 단어는 anta시작, tica 끝
// 학생들이 읽을 수 있는 단어의 최댓값 구하기

let maxRead = 0;
K = K - 5;
if (K < 0) {
  // 남극언어도 다 못 가르침
  console.log(0);
  return;
}
function dfs(idx, depth) {
  if (depth === K) {
    calc();
    return;
  }
  for (let i = idx; i < 26; i++) {
    if (!alphaList[i]) {
      alphaList[i] = true;
      dfs(i + 1, depth + 1);
      alphaList[i] = false;
    }
  }
}

function calc() {
  let readCnt = 0;
  for (let i = 0; i < N; i++) {
    let isRead = true;
    for (let j = 0; j < input[i].length; j++) {
      if (!alphaList[input[i][j].charCodeAt() - 97]) {
        isRead = false;
        break;
      }
    }
    if (isRead) readCnt++;
  }
  maxRead = Math.max(readCnt, maxRead);
}

dfs(0, 0);

console.log(maxRead);

// 1 <= N <= 50, 0 <= K <= 26

/**
 * ex) 1
 * anta + rc + tica
 * anta + hello + tica
 * anta + car + tica
 **/
