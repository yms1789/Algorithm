let fs = require('fs');
let [[N, M], ...input] = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(ele => ele.split(' ').map(Number));
// let [[N, M], ...input] = fs.readFileSync(__dirname + '/test.txt').toString().trim().split('\n').map(ele => ele.split(' ').map(Number));

let arr = Array.from({ length: N + 1 }, () => Array(M + 1).fill(0));
input.splice(0, N).forEach((row, x) => { 
  row.forEach((cell, y) => {
    arr[x + 1][y + 1] = cell;
  });
});
let K = input.splice(0, 1);

/* 누적합 계산 */
for (let x = 1; x <= N; x++) { 
  for (let y = 1; y <= M; y++) { 
    arr[x][y] += arr[x - 1][y] + arr[x][y - 1] - arr[x - 1][y - 1];
  }
}
console.log(arr);
let output = [];
input.forEach((ele) => {
  let [i, j, x, y] = ele;
  output.push(arr[x][y] - arr[i - 1][y] - arr[x][j - 1] + arr[i - 1][j - 1]);
});

console.log(output.join("\n"));
