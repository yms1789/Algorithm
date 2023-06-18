const fs = require('fs');
let [[N, M], ...input] = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(ele => ele.split(' ').map(Number));
// let [[N, M], ...input] = fs.readFileSync(__dirname + '/test.txt').toString().trim().split('\n').map(ele => ele.split(' ').map(Number));

let arr = Array.from({ length: N + 1 }).fill(0);

input[0].forEach((row, x) => { 
  arr[x + 1] = row;
})
for (let i = 1; i < arr.length; i++) { 
  arr[i] += arr[i - 1];
}
let dir = input.slice(1);
let output = [];
dir.forEach(([start, end]) => {
  output.push(arr[end] - arr[start - 1]);
});
console.log(output.join('\n'));