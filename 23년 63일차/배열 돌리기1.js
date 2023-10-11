const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();
let input = stdin.split("\n").map(ele => ele.split(" ").map(Number));

const [N, M, R] = input.shift();
const arr = JSON.parse(JSON.stringify(input));
function rotate() {
  const rect_cnt = Math.min(N, M) / 2;
  for (let cnt = 0; cnt < rect_cnt; cnt++) {
    let [cur_row, cur_col] = [N - cnt - 1, M - cnt - 1];
    let init = arr[cnt][cnt];
    //left
    for (let i = cnt; i < cur_col; i++) {
      arr[cnt][i] = arr[cnt][i + 1];
    }
    // up
    for (let i = cnt; i < cur_row; i++) {
      arr[i][cur_col] = arr[i + 1][cur_col];
    }
    // right
    for (let i = cur_col; i > cnt; i--) {
      arr[cur_row][i] = arr[cur_row][i - 1];
    }
    // down
    for (let i = cur_row; i > cnt; i--) {
      arr[i][cnt] = arr[i - 1][cnt];
    }
    arr[cnt + 1][cnt] = init;
  }
  return arr;
}
for (let i = 0; i < R; i++) {
  rotate();
}
arr.map(row => {
  console.log(row.join(" "));
});
