const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin
  .split("\n")
  .map((ele) => ele.split(" ").map((ele) => Number(ele)));
const [N, M] = input.shift();

let trains = Array.from({ length: N }, () =>
  Array.from({ length: 20 }, () => 0)
);

input.forEach((cmd) => {
  let [state, tnum, tseat] = cmd;
  if (state === 1) {
    // i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라. 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
    trains[tnum - 1][tseat - 1] = 1;
  }
  if (state === 2) {
    // i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
    trains[tnum - 1][tseat - 1] = 0;
  }
  if (state === 3) {
    // i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다. 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
    trains[tnum - 1].unshift(0);
    trains[tnum - 1].pop();
  }
  if (state === 4) {
    // i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다. 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
    trains[tnum - 1].shift();
    trains[tnum - 1].push(0);
  }
});

let trainLog = [];
for (let i = 0; i < trains.length; i++) {
  trainLog.push(trains[i].join(""));
}

trainLog = [...new Set(trainLog)];
console.log(trainLog.length);
