const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim().split("\n");
const input = stdin.map((ele) => ele.split(" ").map((ele) => Number(ele)));

const N = input.shift()[0];
let students = [];
let favorites = {};
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];
let answer = 0;
const map = Array.from({ length: N }, () => Array(N).fill(0));

for (let x of input) {
  students.push(x[0]);
  favorites[x[0]] = x.slice(1);
}

function search_1(student) {
  // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
  // 2. 1을 만족하는 칸이 여러 개면 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
  let candidates = {};
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (!map[i][j]) {
        let count = [0, 0];
        for (let d = 0; d < 4; d++) {
          let [nx, ny] = [i + dx[d], j + dy[d]];
          if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
          if (favorites[student].includes(map[nx][ny])) count[0]++;
          if (!map[nx][ny]) count[1]++;
        }
        const key = JSON.stringify(count);
        if (!candidates[key]) candidates[key] = [[i, j]];
        else candidates[key].push([i, j]);
      }
    }
  }
  const sorted = Object.keys(candidates).sort((a, b) => {
    const [a0, a1] = JSON.parse(a);
    const [b0, b1] = JSON.parse(b);
    if (a0 !== b0) return b0 - a0;
    return b1 - a1;
  });
  const [newRow, newCol] = candidates[sorted[0]][0];
  map[newRow][newCol] = student;
}

function search_2(student) {
  let favCount = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (map[i][j] === student) {
        for (let d = 0; d < 4; d++) {
          const [nx, ny] = [i + dx[d], j + dy[d]];
          if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
          if (favorites[student].includes(map[nx][ny])) favCount++;
        }
      }
    }
  }
  switch (favCount) {
    case 0:
      answer += 0;
      break;
    case 1:
      answer += 1;
      break;
    case 2:
      answer += 10;
      break;
    case 3:
      answer += 100;
      break;
    case 4:
      answer += 1000;
      break;
  }
}

for (let i = 0; i < students.length; i++) {
  search_1(students[i]);
}
for (let i = 0; i < students.length; i++) {
  search_2(students[i]);
}
console.log(answer);
