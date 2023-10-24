const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const [R, C, etc] = fs.readFileSync(filePath).toString().trim().split(" ");
const [N, ...input] = etc.split("\n");

const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

for (let i = 0; i < input.length; i++) {
  input[i] = input[i].split("").slice(0, C);
}

for (let i = 0; i < R; i++) {
  for (let j = 0; j < C; j++) {
    if (input[i][j] === "O") {
      input[i][j] = ["O", 0];
    }
  }
}

function explosion(time) {
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (input[i][j] === ".") continue;
      if (time - input[i][j][1] === 3) {
        input[i][j] = ".";
        for (let d = 0; d < 4; d++) {
          let nx = i + dx[d];
          let ny = j + dy[d];
          if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
          if (time - input[nx][ny][1] === 3) continue;
          input[nx][ny] = ".";
        }
      }
    }
  }
}
function fillBomb(time) {
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (input[i][j] === ".") {
        input[i][j] = ["O", time];
      }
    }
  }
}

for (let i = 2; i <= N; i++) {
  if (i % 2 !== 0) {
    // 터뜨리기
    explosion(i);
  } else {
    // 채우기
    fillBomb(i);
  }
}
for (let i = 0; i < R; i++) {
  for (let j = 0; j < C; j++) {
    if (Array.isArray(input[i][j])) {
      input[i][j] = "O";
    }
  }
}
for (let i = 0; i < input.length; i++) {
  console.log(input[i].join(""));
}
