const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [T] = input[0];

function solution(N, L) {
  // 건너뛰기를 하는데 인접한 통나무 높이 차가 최소가 되게끔 함
  // 건너뛰기 난이도는 인접한 두 통나무 간 높이 차의 최댓값
  // 주어진 나무로 만들 수 있는 최소 난이도를 찾자
  L.sort((a, b) => a - b);
  let newArr = Array.from({ length: L.length }, () => 0);
  let [idx, start, end] = [0, 0, L.length - 1];

  while (idx < L.length) {
    newArr[start] = L[idx];
    idx++;
    start++;
    if (idx >= L.length) break;
    newArr[end] = L[idx];
    idx++;
    end--;
  }

  newArr.push(newArr[0]);
  let maxDiff = 0;
  for (let i = 0; i < newArr.length - 1; i++) {
    maxDiff = Math.max(Math.abs(newArr[i] - newArr[i + 1]), maxDiff);
  }

  console.log(maxDiff);
}

for (let t = 1; t < input.length; ) {
  const [N] = input[t];
  const L = input[t + 1];
  solution(N, L);

  t += 2;
}
