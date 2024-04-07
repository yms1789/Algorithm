const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

const input = stdin.split("\n");
let N = parseInt(input[0]);

let obj = {};
for (let i = 1; i < input.length; i++) {
  obj[input[i]] = (obj[input[i]] || 0) + 1;
}

let sortArr = Object.entries(obj);

sortArr.sort((a, b) => {
  if (a[1] === b[1]) {
    if (a[0] < b[0]) return -1;
    else return 1;
  }
  return b[1] - a[1];
});
console.log(sortArr[0][0]);
