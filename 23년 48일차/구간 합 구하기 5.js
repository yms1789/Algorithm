let fs = require('fs');
let [[N, M], ...input] = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(ele => ele.split(' ').map(Number));
// let [[N, M], ...input] = fs.readFileSync(__dirname + '/test.txt').toString().trim().split('\n').map(ele => ele.split(' ').map(Number));

let arr = Array.from({ length: N + 1 }, () => Array(N + 1).fill(0));
input.slice(0, N).forEach((row, x) => {
  row.forEach((cell, y) => {
    arr[x + 1][y + 1] = cell;
  });
});
for (let x = 1; x <= N; x++) {
  for (let y = 1; y <= N; y++) {
    arr[x][y] += arr[x - 1][y] + arr[x][y - 1] - arr[x - 1][y - 1];
  }
}

let dir = input.slice(N);
let output = [];
dir.forEach(([x1, y1, x2, y2]) => {
  output.push(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]);
});
console.log(output.join('\n'));

