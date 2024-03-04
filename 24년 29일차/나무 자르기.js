const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./test.txt";
const stdin = fs.readFileSync(filePath).toString().trim();

let input = stdin.split("\n").map((ele) => ele.split(" ").map(Number));

const [N, M] = input[0];
let trees = input[1];

trees.sort((a, b) => a - b);

let [left, right] = [0, trees.at(-1)];

let result = 0;
while (left <= right) {
  let mid = parseInt((left + right) / 2);
  let felling = 0;

  trees.forEach((ele) => {
    if (ele - mid > 0) {
      felling += ele - mid;
    }
  });
  if (felling >= M) {
    result = mid;
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}
console.log(result);
