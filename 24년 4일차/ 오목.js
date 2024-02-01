// 19 x 19 오목판
// 가로, 세로, 대각선 방향에 같은 색의 바둑알이 연속적으로 다섯 알 놓이면 그 색이 이김
// 단, 6개 이상 연속적으로 놓이면 이긴 것 X
// 바둑판 상태 주어졌을 때 누가 이겼는지 or 아직 승부가 안났는지 판단

const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

/**
 * 

for (let i = 0; i < 14; i++) {
  for (let j = 0; j < 14; j++) {
    if (input[i][j]) {
      // 해당 칸에 바둑알이 놓여져있는 경우

      // 1. 가로 판단
      let rows = input[i].slice(j, j + 5);
      // 2. 세로 판단
      let cols = [];
      for (let d = i; d < i + 5; d++) {
        cols.push(input[d][j]);
      }
      // 3. 대각 판단
      let slash = [];
      for (let d = 0; d < 5; d++) {
        slash.push(input[i + d][j + d]);
      }
      if (rows.every((ele) => ele === input[i][j])) {
        // 육목인지 판단
        // 1. 가로
        if (input[i][j] === input[i][j + 5]) continue;
        console.log(input[i][j]);
        console.log(`${i + 1} ${j + 1}`);
        return;
      } else if (cols.every((ele) => ele === input[i][j])) {
        // 2. 세로
        if (input[i][j] === input[i + 5][j]) continue;
        console.log(input[i][j]);
        console.log(`${i + 1} ${j + 1}`);
        return;
      } else if (slash.every((ele) => ele === input[i][j])) {
        // 3. 대각
        if (input[i][j] === input[i + 5][j + 5]) continue;
        console.log(input[i][j]);
        console.log(`${i + 1} ${j + 1}`);
        return;
      }
    }
  }
}
console.log(0);
*
*/

const dx = [1, 1, 0, -1];
const dy = [0, 1, 1, 1];
let answer = [0, 0, 0];
function omok(i, j, color) {
  for (let d = 0; d < 4; d++) {
    let [nx, ny] = [i + dx[d], j + dy[d]];
    let cnt = 1;

    while (true) {
      if (nx < 0 || ny < 0 || nx >= 19 || ny >= 19) break;
      if (input[nx][ny] !== color) break;
      cnt++;
      [nx, ny] = [nx + dx[d], ny + dy[d]];
    }
    if (cnt === 5) {
      let [px, py] = [i - dx[d], j - dy[d]];
      if (px >= 0 && py >= 0 && px < 19 && py < 19) {
        if (input[px][py] === color) {
          // 육목
          continue;
        }
      }
      answer[0] = color;
      answer[1] = i;
      answer[2] = j;
      return;
    }
  }
  return;
}

for (let i = 0; i < 19; i++) {
  for (let j = 0; j < 19; j++) {
    if (input[i][j]) {
      omok(i, j, input[i][j]);
    }
  }
}

if (answer[0] === 0) console.log(0);
else console.log(`${answer[0]}\n${answer[1] + 1} ${answer[2] + 1}`);
