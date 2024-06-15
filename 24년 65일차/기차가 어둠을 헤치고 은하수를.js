const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin
  .split("\n")
  .map((ele) => ele.split(" ").map((ele) => Number(ele)));
const [N, M] = input.shift();

let train = Array.from({ length: N + 1 }, () =>
  Array.from({ length: 20 }, () => 0)
);

for (let i = 0; i < M; i++) {
  let [c1, c2, c3] = input[i];
  // 1 i x : i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라. 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
  if (c1 === 1) {
    train[c2][c3 - 1] = 1;
  }
  // 2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
  if (c1 === 2) {
    train[c2][c3 - 1] = 0;
  }
  // 3 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다. 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
  if (c1 === 3) {
    train[c2].unshift(0);
    train[c2].pop();
  }
  // 4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다. 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
  if (c1 === 4) {
    train[c2].shift();
    train[c2].push(0);
  }
}

let trainLog = [];

for (let i = 1; i <= N; i++) {
  trainLog.push(train[i].join(""));
}
trainLog = [...new Set(trainLog)];

console.log(trainLog.length);
